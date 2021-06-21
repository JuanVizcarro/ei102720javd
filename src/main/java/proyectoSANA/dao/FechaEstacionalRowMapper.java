package proyectoSANA.dao;

import org.springframework.jdbc.core.RowMapper;
import proyectoSANA.model.FechaEstacional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public final class FechaEstacionalRowMapper implements RowMapper<FechaEstacional> {
    public FechaEstacional mapRow(ResultSet rs, int rowNum) throws SQLException {
        FechaEstacional fechest = new FechaEstacional();
        fechest.setServicio(rs.getString("Servicio"));
        fechest.setArea(rs.getString("Area"));
        fechest.setFechainicio(rs.getObject("fechainicio", LocalDate.class));
        fechest.setFechafin(rs.getObject("fechafin", LocalDate.class));
        return fechest;
    }
}
