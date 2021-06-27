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

        if (reserva.getFecha().compareTo(now) <= -1)
            errors.rejectValue("fecha", "obligatorio",
                    "La fecha debe ser posterior a la de hoy.");

        if (reserva.getNumeroPersonas()==0)
            errors.rejectValue("numeroPersonas", "obligatorio",
                    "Introduce número de personas.");

        if (reserva.getNumeroPersonas()>reserva.getLimiteReserva())
            errors.rejectValue("numeroPersonas", "obligatorio",
                    "El número de personas no puede exceder el límite (10).");

        if (reserva.getHoraInicio().compareTo(reserva.getHoraFin()) == 1)
            errors.rejectValue("horaInicio", "obligatorio",
                    "La hora de llegada debe ser más pronto de la de salida.");

        if (reserva.getHoraFin().compareTo(reserva.getHoraInicio()) == -1)
            errors.rejectValue("horaFin", "obligatorio",
                    "La hora de salida debe ser más tarde de la de llegada.");

//        if (reserva.getArea().trim().equals(""))
//            errors.rejectValue("area", "obligatorio",
//                    "Este campo es obligatorio.");

        if (reserva.getZona() == null)
            errors.rejectValue("zona", "obligatorio",
                    "Selecciona alguna zona.");

        //if (reserva.getHorarioReserva().trim().equals(""))
        //    errors.rejectValue("horarioReserva", "obligatorio",
         //           "Este campo es obligatorio.");
    }
}
