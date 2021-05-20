package proyectoSANA.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import proyectoSANA.model.Ciudadano;
import proyectoSANA.model.Municipio;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository // En Spring els DAOs van anotats amb @Repository
public class CiudadanoDao {

    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* Afegeix el ciudadano a la base de dades */
    public void addCiudadano(Ciudadano ciudadano) {
        jdbcTemplate.update("INSERT INTO Ciudadano VALUES(?, ?, ?, ?, ?, ?, ?, ?)",
                ciudadano.getUsuario(),ciudadano.getContraseña(), ciudadano.getDNI(), ciudadano.getEmail(),ciudadano.getEdad() , ciudadano.getDireccion(), ciudadano.getMunicipio(), ciudadano.getPais());
    }

    /* Esborra el ciudadano de la base de dades */
    public void deleteCiudadano(String usuario) {
        jdbcTemplate.update("DELETE FROM Ciudadano WHERE usuario = ?",
                usuario);
    }

    /* Esborra el ciudadano de la base de dades */
    public void deleteCiudadano(Ciudadano ciudadano) {
        jdbcTemplate.update("DELETE FROM Ciudadano WHERE usuario = ?",
                ciudadano.getUsuario());
    }

    /* Actualitza els atributs del nadador
       (excepte el nom, que és la clau primària) */
    public void updateCiudadano(Ciudadano ciudadano) {
        jdbcTemplate.update("UPDATE Ciudadano SET DNI = ?, contraseña= ?, email = ?, edad= ?, direccion = ?, municipio = ?,pais = ? WHERE usuario = ?",
                ciudadano.getDNI(),ciudadano.getContraseña(), ciudadano.getEmail(), ciudadano.getEdad(), ciudadano.getDireccion(), ciudadano.getMunicipio(), ciudadano.getPais(), ciudadano.getUsuario());
    }

    /* Obté el municipi amb el dni donat. Torna null si no existeix. */
    public Ciudadano getCiudadano(String usuario) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM Ciudadano WHERE usuario = ?",
                    new CiudadanoRowMapper(),
                    usuario);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }
    public Ciudadano getContraseña(String contra) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM Ciudadano WHERE contraseña = ?",
                    new CiudadanoRowMapper(),
                    contra);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* Obté tots els municipis. Torna una llista buida si no n'hi ha cap. */
    public List<Ciudadano> getCiudadanos() {
        try {
            return jdbcTemplate.query("SELECT * FROM Ciudadano", new CiudadanoRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Ciudadano>();
        }
    }
}
