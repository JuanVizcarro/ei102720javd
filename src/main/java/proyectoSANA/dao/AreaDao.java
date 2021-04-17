package proyectoSANA.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import proyectoSANA.model.Area;
import proyectoSANA.model.Municipio;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
public class AreaDao {
    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addArea(Area area) {
        jdbcTemplate.update("INSERT INTO Area VALUES(?, ?, ?)",
               area.getMunicipio(),area.getTipoAcceso(),area.getDescripcion(),area.getNumeroZonas(),
                area.getNombre(),area.getUbicacionGeografica(),area.getOrientacion(),area.getInstalacion(),
                area.getComentarios());
    }
    public void deleteArea(String nombre) {
        jdbcTemplate.update("DELETE FROM Area WHERE nombre = ?",
                nombre);
    }
    public void deleteArea(Area area) {
        jdbcTemplate.update("DELETE FROM Area WHERE nombre = ?",
                area.getNombre());
    }
    public void updateArea(Area area) {
        jdbcTemplate.update("UPDATE Area SET tipoAcceso = ?, descripcion = ?, numeroZonas = ?, ubicacionGeografica = ?, orientacion = ?, instalacion = ?, comentarios = ? WHERE nombre = ?",
                area.getTipoAcceso(),area.getDescripcion(),area.getNumeroZonas(),
                area.getUbicacionGeografica(),area.getOrientacion(),area.getInstalacion(),
                area.getComentarios(),area.getNombre());
    }
    public Area getArea(String nomMunicipio) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM Area WHERE nombre =?",
                    new AreaRowMapper(),
                    nomMunicipio);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }
    public List<Area> getAreas() {
        try {
            return jdbcTemplate.query("SELECT * FROM Area", new AreaRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Area>();
        }
    }
}
