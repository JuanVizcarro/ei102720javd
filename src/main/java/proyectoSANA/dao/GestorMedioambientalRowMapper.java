package proyectoSANA.dao;

import org.springframework.jdbc.core.RowMapper;
import proyectoSANA.model.GestorMedioambiental;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GestorMedioambientalRowMapper implements RowMapper<GestorMedioambiental> {
    public GestorMedioambiental mapRow(ResultSet rs, int rowNum) throws SQLException {
        GestorMedioambiental gestorMunicipal = new GestorMedioambiental();
        gestorMunicipal.setDNI(rs.getString("DNI"));
        gestorMunicipal.setUsuario(rs.getString("usuario"));
        gestorMunicipal.setContraseña(rs.getString("contraseña"));
        return gestorMunicipal;
    }
}
