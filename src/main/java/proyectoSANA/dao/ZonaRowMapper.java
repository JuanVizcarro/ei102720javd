package proyectoSANA.dao;
import org.springframework.jdbc.core.RowMapper;
import proyectoSANA.model.Zona;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class ZonaRowMapper implements RowMapper<Zona>{
    public Zona mapRow(ResultSet rs, int rowNum) throws SQLException {
        Zona zona = new Zona();
        zona.setNumero(rs.getString("numero"));
        zona.setArea(rs.getString("area"));
        return zona;
    }
}
