package proyectoSANA.dao;



import org.springframework.jdbc.core.RowMapper;
import proyectoSANA.model.Ciudadano;
import proyectoSANA.model.GestorMunicipal;
import proyectoSANA.model.Municipio;

import java.sql.ResultSet;
import java.sql.SQLException;
public class GestorMunicpalRowMapper implements RowMapper<GestorMunicipal> {
    public GestorMunicipal mapRow(ResultSet rs, int rowNum) throws SQLException {
        GestorMunicipal gestorMunicipal = new GestorMunicipal();
        gestorMunicipal.setNombre(rs.getString("nombre"));
        gestorMunicipal.setDni(rs.getString("dni"));
        gestorMunicipal.setPueblo(rs.getString("pueblo"));
        gestorMunicipal.setFechaInicio(rs.getDate("fechaInicio"));
        gestorMunicipal.setFechaFin(rs.getDate("fechaFin"));
        return gestorMunicipal;
    }
}
