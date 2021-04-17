package proyectoSANA.dao;

import proyectoSANA.model.Area;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class AreaRowMapper implements RowMapper<Area> {
    public Area mapRow(ResultSet rs, int rowNum) throws SQLException {
        Area area = new Area();
        area.setMunicipio(rs.getString("municipio"));
        area.setTipoAcceso(rs.getString("tipoAcceso"));
        area.setNumeroZonas(rs.getInt("numeroZonas"));
        area.setDescripcion(rs.getString("descripcion"));
        area.setNombre(rs.getString("nombre"));
        area.setUbicacionGeografica(rs.getString("ubicacionGeografica"));
        area.setOrientacion(rs.getString("orientacion"));
        area.setInstalacion(rs.getString("instalacion"));
        area.setComentarios(rs.getString("comentarios"));
        return area;
    }
}
