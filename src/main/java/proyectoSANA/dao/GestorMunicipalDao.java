package proyectoSANA.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import proyectoSANA.model.Ciudadano;
import proyectoSANA.model.GestorMunicipal;
import proyectoSANA.model.Municipio;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository // En Spring els DAOs van anotats amb @Repository

public class GestorMunicipalDao {
    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* Afegeix el ciudadano a la base de dades */
    public void addGestorMunicipal(GestorMunicipal gestorMunicipal) {
        jdbcTemplate.update("INSERT INTO GestorMunicipal VALUES(?, ?, ?, ?, ?)",
                 gestorMunicipal.getDNI(), gestorMunicipal.getNombre(),gestorMunicipal.getPueblo(),gestorMunicipal.getFechaInicio(),gestorMunicipal.getFechaFin());
    }

    /* Esborra el ciudadano de la base de dades */
    public void deleteGestorMunicipal(String dni) {
        jdbcTemplate.update("DELETE FROM GestorMunicipal WHERE DNI = ?",
                dni);
    }

    /* Esborra el ciudadano de la base de dades */
    public void deleteGestorMunicipal(GestorMunicipal gestorMunicipal) {
        jdbcTemplate.update("DELETE FROM GestorMunicipal WHERE DNI = ?",
                gestorMunicipal.getDNI());
    }

    /* Actualitza els atributs del nadador
       (excepte el nom, que és la clau primària) */
    public void updateGestorMun(GestorMunicipal gestorMunicipal) {
        jdbcTemplate.update("UPDATE GestorMunicipal SET nombre = ?, pueblo = ?, fechaInicio = ?, fechaFin = ? WHERE DNI = ?",
                gestorMunicipal.getNombre(),gestorMunicipal.getPueblo(),gestorMunicipal.getFechaInicio(),gestorMunicipal.getFechaFin(),gestorMunicipal.getDNI());
    }

    /* Obté el municipi amb el dni donat. Torna null si no existeix. */
    public GestorMunicipal getGM(String dni) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM GestorMunicipal WHERE DNI = ?",
                    new GestorMunicpalRowMapper(),
                    dni);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* Obté tots els municipis. Torna una llista buida si no n'hi ha cap. */
    public List<GestorMunicipal> getGM() {
        try {
            return jdbcTemplate.query("SELECT * FROM GestorMunicipal", new GestorMunicpalRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<GestorMunicipal>();
        }
    }

}
