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
    public UserDetails loadUserByUsername(String username, String password, String tipo) {
        UserDetails ciudadano = knownUsers.get(ciudadanoDao.getCiudadano(username));
        UserDetails gestormun = knownUsers.get(gestorMunicipalDao.getGM(username));
        UserDetails user = knownUsers.get(username.trim());
        if (user == null) {
            user.setPassword(password);
            user.setTipo("medioambiente");
            if (user.getPassword().equals(password)){
                return user;
            }else{
                return null;// bad login!
            }
        }
        Ciudadano ciu = ciudadanoDao.getCiudadano(username);
        if (ciu==null) {
            ciudadano.setPassword(password);
            ciudadano.setTipo("ciudadano");
            if (ciudadano.getPassword().equals(password)){
                return ciudadano;
            }else{
                return null;// bad login!
            }
        }
        GestorMunicipal gestorMunicipal = gestorMunicipalDao.getGM(username);
        if (gestorMunicipal == null) {
            gestormun.setPassword(password);
            gestormun.setTipo("municipal");
            if (gestormun.getPassword().equals(password)){
                return gestormun;
            }else{
                return null;// bad login!
            }
        }
        // Usuari no trobat
        return null;

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