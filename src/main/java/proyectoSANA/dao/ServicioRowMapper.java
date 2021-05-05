package proyectoSANA.dao;

import org.springframework.jdbc.core.RowMapper;
import proyectoSANA.model.Servicio;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class ServicioRowMapper implements RowMapper<Servicio> {
    public Servicio mapRow(ResultSet rs, int rowNum) throws SQLException {
        Servicio servicio = new Servicio();

        servicio.setNombre(rs.getString("Nombre"));
        servicio.setDescripcion(rs.getString("Descripcion"));
        servicio.setTipo(rs.getString("Tipo"));
        servicio.setArea(rs.getString("Area"));
        servicio.setNumero(rs.getInt("Numero"));
        servicio.setFechaInicio(rs.getDate("FechaInicio"));
        servicio.setFechaFin(rs.getDate("FechaFin"));

        return servicio;
    }
}