package proyectoSANA.dao;

import java.util.Collection;
import proyectoSANA.model.UserDetails;

public interface UserDao {
    UserDetails loadUserByUsername(String username, String password);
    Collection<UserDetails> listAllUsers();
}
