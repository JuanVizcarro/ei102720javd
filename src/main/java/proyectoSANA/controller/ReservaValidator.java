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

        if (reserva.getNumeroReserva()==0)
            errors.rejectValue("numeroReserva", "obligatorio",
                    "Este campo es obligatorio.");

        if (reserva.getPersona().trim().equals(""))
            errors.rejectValue("persona", "obligatorio",
                    "Este campo es obligatorio.");

        //Date now = LocalDate.now();
        /*if (reserva.getFecha() < now)
            errors.rejectValue("fecha", "obligatorio",
                    "Este campo es obligatorio.");
*/
        if (reserva.getNumeroPersonas()==0)
            errors.rejectValue("numeroPersonas", "obligatorio",
                    "Este campo es obligatorio.");

        if (reserva.getArea().trim().equals(""))
            errors.rejectValue("area", "obligatorio",
                    "Este campo es obligatorio.");

        if (reserva.getZona().trim().equals(""))
            errors.rejectValue("zona", "obligatorio",
                    "Este campo es obligatorio.");

        if (reserva.getHorarioReserva()==null)
            errors.rejectValue("horarioReserva", "obligatorio",
                    "Este campo es obligatorio.");
    }
}
