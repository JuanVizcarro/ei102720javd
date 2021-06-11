package proyectoSANA.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import proyectoSANA.model.Municipio;
import proyectoSANA.model.Reserva;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository // En Spring els DAOs van anotats amb @Repository
public class ReservaDao {

    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* Afegeix la reserva a la base de dades */
    public void addReserva(Reserva reserva) {
        jdbcTemplate.update("INSERT INTO Reserva VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                reserva.getNumeroReserva(), reserva.getPersona(), reserva.getFecha(), reserva.getNumeroPersonas(),reserva.getHoraInicio(), reserva.getHoraFin(), reserva.getLimiteReserva(), reserva.getArea(), reserva.getZona(), reserva.getHorarioReserva());
    }

    /* Esborra la reserva de la base de dades */
    public void deleteReserva(String numeroReserva) {
        jdbcTemplate.update("DELETE FROM Reserva WHERE numeroReserva = ?",
                numeroReserva);
    }

    /* Esborra la reserva de la base de dades */
    public void deleteReserva(Reserva reserva) {
        jdbcTemplate.update("DELETE FROM Reserva WHERE numeroReserva = ?",
                reserva.getNumeroReserva());
    }

    /* Actualitza els atributs del nadador
       (excepte el nom, que és la clau primària) */
    public void updateReserva(Reserva reserva) {
        jdbcTemplate.update("UPDATE Reserva SET persona = ?, fecha = ?, numeroPersonas = ?, horaInicio = ?, horaFin = ?, limiteReserva = ?, area = ?, zona = ?, horarioReserva = ? WHERE numeroReserva = ?",
                reserva.getPersona(), reserva.getFecha(), reserva.getNumeroPersonas(), reserva.getHoraInicio(), reserva.getHoraFin(), reserva.getLimiteReserva(), reserva.getArea(), reserva.getZona(), reserva.getHorarioReserva(), reserva.getNumeroReserva());
    }

    /* Obté la reserv amb el dni i  fecha donats. Torna null si no existeix. */
    public Reserva getReserva(String numeroReserva) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM Reserva WHERE numeroReserva = ?",
                    new ReservaRowMapper(),
                    numeroReserva);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* Obté tots els municipis. Torna una llista buida si no n'hi ha cap. */
    public List<Reserva> getReservas() {
        try {
            return jdbcTemplate.query("SELECT * FROM Reserva", new ReservaRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }

    public int getOcupacion(String area) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT SUM(numeroPersonas) FROM Reserva WHERE area = ? GROUP BY area",
                    Integer.class,
                    area);
        }
        catch(EmptyResultDataAccessException e) {
            System.out.println("sumar ocupación no funciona");
            return -1;
        }
    }

}
