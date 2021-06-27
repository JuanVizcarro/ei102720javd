package proyectoSANA.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import proyectoSANA.model.FechaEstacional;

import java.time.LocalDate;

public class FechaEstacionalValidator implements Validator{
    @Override
    public boolean supports(Class<?> cls) {
        return FechaEstacional.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        FechaEstacional fech = (FechaEstacional) obj;
        LocalDate now = LocalDate.now();
        if (fech.getFechainicio().compareTo(now) <= -1) {
            errors.rejectValue("fechainicio", "obligatorio",
                    "La fecha de inicio debe ser posterior a la de hoy.");
        }

        if (fech.getFechainicio().compareTo(fech.getFechafin()) >= 1) {
            errors.rejectValue("fechainicio", "obligatorio",
                    "La fecha de inicio debe ser más pronto que la de fin.");
        }

        if (fech.getFechafin().compareTo(fech.getFechainicio()) <= -1){
            errors.rejectValue("fechafin", "obligatorio",
                    "La fecha de fin debe ser más tarde que la de inicio.");
        }

    }
}
