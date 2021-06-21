package proyectoSANA.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import proyectoSANA.model.FechaEstacional;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository // En Spring els DAOs van anotats amb @Repository
public class FechaEstacionalDao {
    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* Afegeix el municipio a la base de dades */
    public void addServicio(FechaEstacional servicio) {
        jdbcTemplate.update("INSERT INTO fechaestacional VALUES(?, ?, ?, ?)",
                servicio.getServicio(), servicio.getArea(),servicio.getFechainicio(), servicio.getFechafin());
    }

    public void deleteServicio(String servicio, String area, LocalDate fechainicio) {
        jdbcTemplate.update("DELETE FROM fechaestacional WHERE servicio = ? and area = ? and fechainicio = ?",
                servicio, area, fechainicio);

    }


//    public void deleteServicio(FechaEstacional servicio) {
//        jdbcTemplate.update("DELETE FROM fechaestacional WHERE nombre = ? and area = ? and fechainicio = ?",
//                servicio.getServicio(), servicio.getArea(), servicio.getFechainicio());
//    }

    public FechaEstacional getFechaEstacional(String area) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM fechaestacional WHERE area =?",
                    new FechaEstacionalRowMapper(),
                    area);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<FechaEstacional> getFechasEstacionales() {
        try {
            return jdbcTemplate.query("SELECT * FROM fechaestacional", new FechaEstacionalRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }
}



