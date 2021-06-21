package proyectoSANA.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import proyectoSANA.model.Municipio;
import proyectoSANA.model.Reserva;
import proyectoSANA.model.ServicioFijo;
import proyectoSANA.model.Zona;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository // En Spring els DAOs van anotats amb @Repository
public class ServicioFijoDao {
    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* Afegeix el municipio a la base de dades */
    public void addServicio(ServicioFijo servicio) {
        jdbcTemplate.update("INSERT INTO Serviciofijo VALUES(?, ?)",
                servicio.getNombre(), servicio.getDescripcion());
    }

    public void deleteServicio(String nombre) {
        jdbcTemplate.update("DELETE FROM Serviciofijo WHERE nombre = ?",
                nombre);

    }


    public void updateServicio(ServicioFijo servicio) {
        jdbcTemplate.update("UPDATE Serviciofijo SET descripcion = ? WHERE nombre = ?",
                servicio.getDescripcion(), servicio.getNombre());
    }

    public void deleteServicio(ServicioFijo servicio) {
        jdbcTemplate.update("DELETE FROM Serviciofijo WHERE nombre = ?",
                servicio.getNombre());
    }

    public ServicioFijo getServicio(String nombre) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM Serviciofijo WHERE nombre =?",
                    new ServicioFijoRowMapper(),
                    nombre);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<ServicioFijo> getServiciosFijos() {
        try {
            return jdbcTemplate.query("SELECT * FROM Serviciofijo", new ServicioFijoRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }
}



