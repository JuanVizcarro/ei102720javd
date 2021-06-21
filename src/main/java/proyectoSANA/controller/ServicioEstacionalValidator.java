package proyectoSANA.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import proyectoSANA.model.ServicioEstacional;

public class ServicioEstacionalValidator implements Validator{
    @Override
    public boolean supports(Class<?> cls) {
        return ServicioEstacional.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        ServicioEstacional servicio = (ServicioEstacional) obj;

        if (servicio.getNombre().trim().equals(""))
            errors.rejectValue("nombre", "obligatorio",
                    "Este campo es obligatorio.");

    }
}