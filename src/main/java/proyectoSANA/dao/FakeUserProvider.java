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
        UserDetails ciudadano = knownUsers.get(ciudadanoDao.getCiudadano(username));
        UserDetails gestormun = knownUsers.get(gestorMunicipalDao.getGM(username));
        UserDetails user = knownUsers.get(username.trim());
        if (user == null) {
            Ciudadano ciu = ciudadanoDao.getCiudadano(username);
            if (ciu==null){
                GestorMunicipal gestorMunicipal = gestorMunicipalDao.getGM(username);
                if (gestorMunicipal == null){
                    return null;
                }
            }
        }
        // Usuari no trobat
        // Contrasenya
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
            Ciudadano ciu = ciudadanoDao.getContraseña(password);
            if (ciu == null){
                GestorMunicipal gestorMunicipal = gestorMunicipalDao.getContra(password);
                if (gestorMunicipal==null){
                    return null;
                }

            //passwordEncryptor.checkPassword(password, user.getPassword())
            // Es deuria esborrar de manera segura el camp password abans de tornar-lo
            return user;
        }
        else {
            return user; // bad login!
        }
    }

    @Override
    public Collection<UserDetails> listAllUsers() {
        return knownUsers.values();
    }
}