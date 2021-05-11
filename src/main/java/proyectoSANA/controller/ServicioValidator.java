package proyectoSANA.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import proyectoSANA.model.Servicio;

public class ServicioValidator implements Validator{
    @Override
    public boolean supports(Class<?> cls) {
        return Servicio.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Servicio servicio = (Servicio) obj;

        if (servicio.getNombre().trim().equals(""))
            errors.rejectValue("nombre", "obligatorio",
                    "Este campo es obligatorio.");

        if (servicio.getIdentificador().trim().equals(""))
            errors.rejectValue("identificador", "obligatorio",
                    "Este campo es obligatorio.");

        if (servicio.getTipo().trim().equals(""))
            errors.rejectValue("tipo", "obligatorio",
                    "Este campo es obligatorio.");

        if (servicio.getArea().trim().equals(""))
            errors.rejectValue("area", "obligatorio",
                    "Este campo es obligatorio.");

        if (servicio.getNumero() == 0)
            errors.rejectValue("numero", "obligatorio",
                    "Este campo es obligatorio.");

        if (servicio.getFechaInicio().compareTo(servicio.getFechaFin()) == 1)
            errors.rejectValue("fechaInicio", "obligatorio",
                    "Fecha de inicio debe ser menor que la fecha fin.");

        if (servicio.getFechaFin().compareTo(servicio.getFechaInicio()) == -1)
            errors.rejectValue("fechaFin", "obligatorio",
                    "Fecha fin debe ser posterior a la fecha de inicio.");

    }
}