package proyectoSANA.dao;

import proyectoSANA.model.Ciudadano;

import org.springframework.jdbc.core.RowMapper;
import proyectoSANA.model.Municipio;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class CiudadanoRowMapper  implements RowMapper<Ciudadano> {
    public Ciudadano mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setUsuario(rs.getString("usuario"));
        ciudadano.setContraseña(rs.getString("contraseña"));
        ciudadano.setDNI(rs.getString("DNI"));
        ciudadano.setEmail(rs.getString("email"));
        ciudadano.setEdad(rs.getInt("edad"));
        ciudadano.setDireccion(rs.getString("direccion"));
        ciudadano.setMunicipio(rs.getString("municipio"));
        ciudadano.setPais(rs.getString("pais"));
        return ciudadano;
    }
}
