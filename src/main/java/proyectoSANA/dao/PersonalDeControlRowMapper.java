package proyectoSANA.dao;
import proyectoSANA.model.Municipio;
import proyectoSANA.model.PersonalDeControl;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
public final class PersonalDeControlRowMapper implements RowMapper<PersonalDeControl> {
    public PersonalDeControl mapRow(ResultSet rs, int rowNum) throws SQLException {
        PersonalDeControl personalDeControl= new PersonalDeControl();
        personalDeControl.setDni(rs.getString("dni"));
        personalDeControl.setEmail(rs.getString("email"));
        personalDeControl.setNombre(rs.getString("nombre"));
        personalDeControl.setPueblo(rs.getString("pueblo"));
        personalDeControl.setArea(rs.getString("area"));

        return personalDeControl;
    }
}
