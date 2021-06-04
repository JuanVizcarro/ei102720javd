package proyectoSANA.dao;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import proyectoSANA.model.GestorMunicipal;
import proyectoSANA.model.UserDetails;
import proyectoSANA.model.Ciudadano;




@Repository
public class FakeUserProvider implements UserDao {
    final Map<String, UserDetails> knownUsers = new HashMap<String, UserDetails>();
    @Autowired
    private CiudadanoDao ciudadanoDao;
    @Autowired
    public void setCiudadanoDao(CiudadanoDao ciudadanoDao) {
        this.ciudadanoDao = ciudadanoDao;
    }
    @Autowired
    private GestorMunicipalDao gestorMunicipalDao;
    @Autowired
    public void setGestorMunicipalDao(GestorMunicipalDao gestorMunicipalDao) {
        this.gestorMunicipalDao = gestorMunicipalDao;
    }


    public FakeUserProvider() {
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        UserDetails userAlice = new UserDetails();
        userAlice.setUsername("alice");
        userAlice.setPassword(passwordEncryptor.encryptPassword("alice"));
        userAlice.setTipo("medioambiente");
        knownUsers.put("alice", userAlice);

        UserDetails userBob = new UserDetails();
        userBob.setUsername("bob");
        userBob.setPassword(passwordEncryptor.encryptPassword("bob"));
        userBob.setTipo("medioambiente");
        knownUsers.put("bob", userBob);



        UserDetails user = new UserDetails();
        user.setUsername(user.getUsername());
        //user.setPassword(passwordEncryptor.encryptPassword(user.getPassword()));
        knownUsers.put(user.getPassword(), user);

    }

    @Override
    public UserDetails loadUserByUsername(String username, String password) {
        System.out.println("llegue");
        UserDetails ciudadano = new UserDetails();
        UserDetails gestormun = new UserDetails();
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        UserDetails user = knownUsers.get(username.trim());
        if (user == null) {         //entra si no es medioambiente
            Ciudadano ciu = ciudadanoDao.getCiudadano(username);
            if (ciu == null) {      //entra si no es ciudadano
                GestorMunicipal gm = gestorMunicipalDao.getGM(username);
                if (gm != null) {   //entra si es municipal
                    gestormun.setUsername(username);
                    gestormun.setTipo("municipal");
                    if (passwordEncryptor.checkPassword(password, gm.getContraseña())) {
                        gestormun.setPassword(password);
                        return gestormun;
                    }
                    System.out.println("USUARIO INCORRECTO");       //no es ninguno
                    return null;
                }
            }
            ciudadano.setUsername(username);
            ciudadano.setTipo("ciudadano");
            if (passwordEncryptor.checkPassword(password, ciu.getContraseña())) {
                ciudadano.setPassword(password);
                ciudadano.setDni(ciu.getDNI());
                return ciudadano;
            }
            return null;
        }
        return user;
    }

    public String getTipo(String username){
        return knownUsers.get(username).getTipo();
    }

    public boolean setTipo(String username, String tipo){
       return knownUsers.get(username).setTipo(tipo);
    }

    @Override
    public Collection<UserDetails> listAllUsers() {
        return knownUsers.values();
    }
}