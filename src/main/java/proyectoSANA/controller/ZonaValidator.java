package proyectoSANA.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import proyectoSANA.model.Zona;

public class ZonaValidator implements Validator{

    @Override
    public boolean supports(Class<?> cls) {
        return Zona.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Zona zona = (Zona) obj;

        if (zona.getArea().trim().equals(""))
            errors.rejectValue("area", "obligatorio",
                    "Este campo es obligatorio.");

        if (zona.getNumero().trim().equals(""))
            errors.rejectValue("numero", "obligatorio",
                    "Este campo es obligatorio.");
    }
}
