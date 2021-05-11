package proyectoSANA.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import proyectoSANA.model.Area;
import proyectoSANA.model.Reserva;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ReservaValidator implements Validator{
    @Override
    public boolean supports(Class<?> cls) {
        return Reserva.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Reserva reserva = (Reserva) obj;
        LocalDate now = LocalDate.now();

        if (reserva.getNumeroReserva().trim().equals(""))
            errors.rejectValue("numeroReserva", "obligatorio",
                    "Este campo es obligatorio.");

        if (reserva.getPersona().trim().equals(""))
            errors.rejectValue("persona", "obligatorio",
                    "Este campo es obligatorio.");

        if (String.reserva.getFecha())
            errors.rejectValue("fecha", "obligatorio",
                    "Este campo es obligatorio.");

        if (reserva.getFecha().compareTo(now) == -1)
            errors.rejectValue("fecha", "obligatorio",
                    "La fecha debe ser posterior a la de hoy.");

        if (reserva.getNumeroPersonas()==0)
            errors.rejectValue("numeroPersonas", "obligatorio",
                    "Este campo es obligatorio.");

        /*if (reserva.getHoraInicio().compareTo(null) == 0)
            errors.rejectValue("horaFin", "obligatorio",
                    "Este campo es obligatorio.");

        if (reserva.getHoraFin().compareTo(null) == 0)
            errors.rejectValue("horaFin", "obligatorio",
                    "Este campo es obligatorio.");*/

        if (reserva.getHoraInicio().compareTo(reserva.getHoraFin()) == 1)
            errors.rejectValue("horaInicio", "obligatorio",
                    "La hora de salida debe ser más tarde de la de llegada.");

        if (reserva.getArea().trim().equals(""))
            errors.rejectValue("area", "obligatorio",
                    "Este campo es obligatorio.");

        if (reserva.getZona()==0)
            errors.rejectValue("zona", "obligatorio",
                    "Este campo es obligatorio.");

        if (reserva.getHorarioReserva().trim().equals(""))
            errors.rejectValue("horarioReserva", "obligatorio",
                    "Este campo es obligatorio.");
    }
}
