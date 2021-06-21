package proyectoSANA.dao;

import org.springframework.jdbc.core.RowMapper;
import proyectoSANA.model.ServicioEstacional;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class ServicioEstacionalRowMapper implements RowMapper<ServicioEstacional> {
    public ServicioEstacional mapRow(ResultSet rs, int rowNum) throws SQLException {
        ServicioEstacional servicio = new ServicioEstacional();
        servicio.setNombre(rs.getString("Nombre"));
        servicio.setDescripcion(rs.getString("Descripcion"));

        return servicio;
    }
}
