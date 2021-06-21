package proyectoSANA.dao;

import org.springframework.jdbc.core.RowMapper;
import proyectoSANA.model.ServicioFijo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public final class ServicioFijoRowMapper implements RowMapper<ServicioFijo> {
    public ServicioFijo mapRow(ResultSet rs, int rowNum) throws SQLException {
        ServicioFijo servicio = new ServicioFijo();
        servicio.setNombre(rs.getString("Nombre"));
        servicio.setDescripcion(rs.getString("Descripcion"));

        return servicio;
    }
}
