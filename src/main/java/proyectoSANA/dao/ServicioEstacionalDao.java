package proyectoSANA.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import proyectoSANA.model.ServicioEstacional;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository // En Spring els DAOs van anotats amb @Repository
public class ServicioEstacionalDao {
    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* Afegeix el municipio a la base de dades */
    public void addServicio(ServicioEstacional servicio) {
        jdbcTemplate.update("INSERT INTO Servicioestacional VALUES(?, ?)",
                servicio.getNombre(), servicio.getDescripcion());
    }

    public void deleteServicio(String nombre) {
        jdbcTemplate.update("DELETE FROM Servicioestacional WHERE nombre = ?",
                nombre);

    }


    public void updateServicio(ServicioEstacional servicio) {
        jdbcTemplate.update("UPDATE Servicioestacional SET descripcion = ? WHERE nombre = ?",
                servicio.getDescripcion(), servicio.getNombre());
    }

    public void deleteServicio(ServicioEstacional servicio) {
        jdbcTemplate.update("DELETE FROM Servicioestacional WHERE nombre = ?",
                servicio.getNombre());
    }

    public ServicioEstacional getServicio(String nombre) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM Servicioestacional WHERE nombre =?",
                    new ServicioEstacionalRowMapper(),
                    nombre);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<ServicioEstacional> getServiciosEstacionales() {
        try {
            return jdbcTemplate.query("SELECT * FROM Servicioestacional", new ServicioEstacionalRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }
}



