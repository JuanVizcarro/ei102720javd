package proyectoSANA.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import proyectoSANA.model.ServicioFijo;

public class ServicioFijoValidator implements Validator{
    @Override
    public boolean supports(Class<?> cls) {
        return ServicioFijo.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        ServicioFijo servicio = (ServicioFijo) obj;

        if (servicio.getNombre().trim().equals(""))
            errors.rejectValue("nombre", "obligatorio",
                    "Este campo es obligatorio.");

    }
}