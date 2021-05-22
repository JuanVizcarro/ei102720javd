package proyectoSANA.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import proyectoSANA.model.Ciudadano;
import proyectoSANA.model.GestorMedioambiental;
import proyectoSANA.model.GestorMunicipal;
import proyectoSANA.model.Municipio;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class GestorMedioambientalDao {
    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* Afegeix el ciudadano a la base de dades */
    public void addGestorMedioambiental(GestorMedioambiental gestorMedioambiental) {
        jdbcTemplate.update("INSERT INTO GestorMedioambiental VALUES(?, ?, ?, ?, ?, ?)",
                gestorMedioambiental.getDNI(), gestorMedioambiental.getUsuario(),gestorMedioambiental.getContraseña());
    }

    /* Esborra el ciudadano de la base de dades */
    public void deleteGestorMedioambiental(String usuario) {
        jdbcTemplate.update("DELETE FROM GestorMedioambiental WHERE usuario = ?",
                usuario);
    }

    /* Esborra el ciudadano de la base de dades */
    public void deleteGestorMedioambiental(GestorMedioambiental gestorMedioambiental) {
        jdbcTemplate.update("DELETE FROM GestorMedioambiental WHERE usuario = ?",
                gestorMedioambiental.getUsuario());
    }

    /* Actualitza els atributs del nadador
       (excepte el nom, que és la clau primària) */
    public void updateGestorMedioambiental(GestorMedioambiental gestorMedioambiental) {
        jdbcTemplate.update("UPDATE GestorMedioambiental SET DNI = ?, contraseña = ?, pueblo = ?, fechaInicio = ?, fechaFin = ? WHERE usuario = ?",
                gestorMedioambiental.getDNI(),gestorMedioambiental.getContraseña(),gestorMedioambiental.getUsuario());
    }

    /* Obté el municipi amb el dni donat. Torna null si no existeix. */
    public GestorMedioambiental getGM(String usuario) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM GestorMedioambiental WHERE usuario = ?",
                    new GestorMedioambientalRowMapper(),
                    usuario);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    public GestorMedioambiental getContra(String contraseña) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM GestorMedioambiental WHERE contraseña = ?",
                    new GestorMedioambientalRowMapper(),
                    contraseña);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* Obté tots els municipis. Torna una llista buida si no n'hi ha cap. */
    public  List<GestorMedioambiental> getGM() {
        try {
            return jdbcTemplate.query("SELECT * FROM GestorMedioambiental", new GestorMedioambientalRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<GestorMedioambiental>();
        }
    }
}
