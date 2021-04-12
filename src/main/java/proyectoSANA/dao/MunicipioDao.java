package proyectoSANA.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import proyectoSANA.model.Municipio;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository // En Spring els DAOs van anotats amb @Repository
public class MunicipioDao {

    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* Afegeix el municipio a la base de dades */
    public void addMunicipio(Municipio municipio) {
        jdbcTemplate.update("INSERT INTO Municipio VALUES(?, ?, ?)",
                municipio.getNombre(), municipio.getTlf(), municipio.getCp());
    }

    /* Esborra el nadador de la base de dades */
    public void deleteMunicipio(String nom) {
        jdbcTemplate.update("DELETE FROM Municipio WHERE nombre = ?",
                nom);
    }

    /* Esborra el nadador de la base de dades */
    public void deleteMunicipio(Municipio municipio) {
        jdbcTemplate.update("DELETE FROM Municipio WHERE nombre = ?",
                municipio.getNombre());
    }

    /* Actualitza els atributs del nadador
       (excepte el nom, que és la clau primària) */
    public void updateMunicipio(Municipio municipio) {
        jdbcTemplate.update("UPDATE Municipio SET tlf = ?, cp = ? WHERE nombre = ?",
                municipio.getTlf(), municipio.getCp(), municipio.getNombre());
    }

    /* Obté el municipi amb el nom donat. Torna null si no existeix. */
        public Municipio getMunicipio(String nomMunicipio) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM Municipio WHERE nombre =?",
                    new MunicipioRowMapper(),
                    nomMunicipio);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* Obté tots els municipis. Torna una llista buida si no n'hi ha cap. */
    public List<Municipio> getMunicipios() {
        try {
            return jdbcTemplate.query("SELECT * FROM Municipio", new MunicipioRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Municipio>();
        }
    }
}