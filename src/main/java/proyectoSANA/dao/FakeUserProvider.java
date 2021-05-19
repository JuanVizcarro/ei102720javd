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
        knownUsers.put("alice", userAlice);

        UserDetails userBob = new UserDetails();
        userBob.setUsername("bob");
        userBob.setPassword(passwordEncryptor.encryptPassword("bob"));
        knownUsers.put("bob", userBob);


        UserDetails user = new UserDetails();
        user.setUsername(user.getUsername());
        user.setPassword(passwordEncryptor.encryptPassword(user.getPassword()));
        knownUsers.put(user.getPassword(), user);

    }

    @Override
    public UserDetails loadUserByUsername(String username, String password) {

        UserDetails user = knownUsers.get(username.trim());
        if (user == null) {
            ciudadanoDao.getCiudadano(username);
        } else {
            gestorMunicipalDao.getGM(username);
        }
        // Usuari no trobat
        // Contrasenya
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        if (passwordEncryptor.checkPassword(password, user.getPassword())) {
            // Es deuria esborrar de manera segura el camp password abans de tornar-lo
            return user;
        }
        else {
            return null; // bad login!
        }
    }

    @Override
    public Collection<UserDetails> listAllUsers() {
        return knownUsers.values();
    }
}