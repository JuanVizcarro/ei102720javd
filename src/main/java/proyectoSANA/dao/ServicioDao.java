package proyectoSANA.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import proyectoSANA.model.Municipio;
import proyectoSANA.model.Reserva;
import proyectoSANA.model.Servicio;
import proyectoSANA.model.Zona;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository // En Spring els DAOs van anotats amb @Repository
public class ServicioDao {
    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* Afegeix el municipio a la base de dades */
    public void addServicio(Servicio servicio) {
        jdbcTemplate.update("INSERT INTO Servicio VALUES(?, ?, ?, ?, ?, ?, ?, ?)",
                servicio.getIdentificador(), servicio.getNombre(), servicio.getDescripcion(), servicio.getTipo(), servicio.getArea(), servicio.getNumero(), servicio.getFechaInicio(), servicio.getFechaFin());
    }

    public void deleteServicio(String identificador) {
        jdbcTemplate.update("DELETE FROM Servicio WHERE identificador = ?",
                identificador);

    }


    public void updateServicio(Servicio servicio) {
        jdbcTemplate.update("UPDATE Servicio SET nombre = ?, descripcion = ?, tipo = ?, area= ?, numero= ?, fechaInicio= ?, fechaFin= ? WHERE identificador = ?",
                servicio.getNombre(), servicio.getDescripcion(),servicio.getTipo(),servicio.getArea(),servicio.getNumero(),servicio.getFechaInicio(), servicio.getFechaFin(),servicio.getIdentificador());
    }

    public void deleteServicio(Servicio servicio) {
        jdbcTemplate.update("DELETE FROM Servicio WHERE identificador = ?",
                servicio.getIdentificador());
    }

    public Servicio getServicio(String identificador) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM Servicio WHERE identificador =?",
                    new ServicioRowMapper(),
                    identificador);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Servicio> getServicios() {
        try {
            return jdbcTemplate.query("SELECT * FROM Servicio", new ServicioRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }
}



