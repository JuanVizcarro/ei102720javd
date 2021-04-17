package proyectoSANA.dao;

import org.springframework.jdbc.core.RowMapper;
import proyectoSANA.model.Reserva;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservaRowMapper implements RowMapper<Reserva> {
    public Reserva mapRow(ResultSet rs, int rowNum) throws SQLException {
        Reserva reserva = new Reserva();

        reserva.setNumeroReserva(rs.getInt("numeroReserva"));
        reserva.setPersona(rs.getString("persona"));
        reserva.setFecha(rs.getDate("fecha"));
        reserva.setNumeroPersonas(rs.getInt("numeroPersonas"));
        reserva.setLimiteReserva(rs.getInt("limiteReserva"));
        reserva.setArea(rs.getString("area"));
        reserva.setZona(rs.getString("zona"));
        reserva.setHorarioReserva(rs.getDate("horarioReserva"));

        return reserva;
    }
}
