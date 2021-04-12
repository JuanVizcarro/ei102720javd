package proyectoSANA.dao;

import proyectoSANA.model.Municipio;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class MunicipioRowMapper implements RowMapper<Municipio> {
    public Municipio mapRow(ResultSet rs, int rowNum) throws SQLException {
        Municipio municipio = new Municipio();
        municipio.setNom(rs.getString("nom"));
        municipio.setTelefono(rs.getInt("telefono"));
        municipio.setCp(rs.getInt("cp"));
        return municipio;
    }
}