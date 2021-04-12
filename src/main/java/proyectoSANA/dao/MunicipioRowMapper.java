package proyectoSANA.dao;

import proyectoSANA.model.Municipio;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class MunicipioRowMapper implements RowMapper<Municipio> {
    public Municipio mapRow(ResultSet rs, int rowNum) throws SQLException {
        Municipio municipio = new Municipio();
        municipio.setNombre(rs.getString("nombre"));
        municipio.setTlf(rs.getInt("tlf"));
        municipio.setCp(rs.getInt("cp"));
        return municipio;
    }
}