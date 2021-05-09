package proyectoSANA.dao;

import org.springframework.jdbc.core.RowMapper;
import proyectoSANA.model.Reserva;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;

public class ReservaRowMapper implements RowMapper<Reserva> {
    public Reserva mapRow(ResultSet rs, int rowNum) throws SQLException {
        Reserva reserva = new Reserva();

        reserva.setNumeroReserva(rs.getInt("numeroReserva"));
        reserva.setPersona(rs.getString("persona"));
        reserva.setFecha(rs.getObject("fecha", LocalDate.class));
        reserva.setNumeroPersonas(rs.getInt("numeroPersonas"));
        Time t = rs.getTime("horaInicio");
        reserva.setHoraInicio(t != null ? t.toLocalTime() : null);
        t = rs.getTime("horaFin");
        reserva.setHoraFin(t != null ? t.toLocalTime() : null);
        reserva.setLimiteReserva(rs.getInt("limiteReserva"));
        reserva.setArea(rs.getString("area"));
        reserva.setZona(rs.getString("zona"));
        reserva.setHorarioReserva(rs.getString("horarioReserva"));

        return reserva;
    }
}
