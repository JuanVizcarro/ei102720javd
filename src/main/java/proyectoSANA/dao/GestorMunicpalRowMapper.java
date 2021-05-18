package proyectoSANA.dao;



import org.springframework.jdbc.core.RowMapper;

import proyectoSANA.model.GestorMunicipal;


import java.sql.ResultSet;
import java.sql.SQLException;
public class GestorMunicpalRowMapper implements RowMapper<GestorMunicipal> {
    public GestorMunicipal mapRow(ResultSet rs, int rowNum) throws SQLException {
        GestorMunicipal gestorMunicipal = new GestorMunicipal();
        gestorMunicipal.setDNI(rs.getString("DNI"));
        gestorMunicipal.setUsuario(rs.getString("usuario"));
        gestorMunicipal.setContraseña(rs.getString("contraseña"));
        gestorMunicipal.setPueblo(rs.getString("pueblo"));
        gestorMunicipal.setFechaInicio(rs.getDate("fechaInicio"));
        gestorMunicipal.setFechaFin(rs.getDate("fechaFin"));
        return gestorMunicipal;
    }
}
