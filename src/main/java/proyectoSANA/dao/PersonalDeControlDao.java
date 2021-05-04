package proyectoSANA.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import proyectoSANA.model.Municipio;
import proyectoSANA.model.PersonalDeControl;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository // En Spring els DAOs van anotats amb @Repository
public class PersonalDeControlDao {
    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* Afegeix el municipio a la base de dades */
    public void addPersonal(PersonalDeControl personalDeControl) {
        jdbcTemplate.update("INSERT INTO PersonalDeControl VALUES(?, ?, ?, ?, ?)",
                personalDeControl.getDni(), personalDeControl.getEmail(), personalDeControl.getNombre(), personalDeControl.getPueblo(), personalDeControl.getArea());
    }

    /* Esborra el nadador de la base de dades */
    public void deletePersonal(String dni) {
        jdbcTemplate.update("DELETE FROM PersonalDeControl WHERE dni = ?",
                dni);
    }

    /* Esborra el nadador de la base de dades */
    public void deletePersonal(PersonalDeControl personalDeControl) {
        jdbcTemplate.update("DELETE FROM PersonalDeControl WHERE dni = ?",
                personalDeControl.getDni());
    }

    /* Actualitza els atributs del nadador
       (excepte el nom, que és la clau primària) */
    public void updatePersonal(PersonalDeControl personalDeControl) {
        jdbcTemplate.update("UPDATE PersonalDeControl SET email = ?, nombre = ?, pueblo= ?, area= ? WHERE dni = ?",
                personalDeControl.getEmail(), personalDeControl.getNombre(), personalDeControl.getPueblo(), personalDeControl.getArea(), personalDeControl.getDni());
    }

    /* Obté el municipi amb el nom donat. Torna null si no existeix. */
    public PersonalDeControl getPersonal(String dni) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM PersonalDeControl WHERE dni =?",
                    new PersonalDeControlRowMapper(),
                    dni);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* Obté tots els municipis. Torna una llista buida si no n'hi ha cap. */
    public List<PersonalDeControl> getPersonal() {
        try {
            return jdbcTemplate.query("SELECT * FROM PersonalDeControl", new PersonalDeControlRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<PersonalDeControl>();
        }
    }

}
