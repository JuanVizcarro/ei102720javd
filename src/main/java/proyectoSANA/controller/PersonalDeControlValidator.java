package proyectoSANA.controller;

import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import proyectoSANA.model.PersonalDeControl;
import proyectoSANA.model.Zona;

public class PersonalDeControlValidator implements Validator {
    @Override
    public boolean supports(Class<?> cls) {
        return PersonalDeControl.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        PersonalDeControl personalDeControl = (PersonalDeControl) obj;

        if (personalDeControl.getDni().trim().equals(""))
            errors.rejectValue("dni", "obligatorio",
                    "Este campo es obligatorio.");

        if (personalDeControl.getEmail().trim().equals(""))
            errors.rejectValue("email", "obligatorio",
                    "Este campo es obligatorio.");

        if (personalDeControl.getNombre().trim().equals(""))
            errors.rejectValue("nombre", "obligatorio",
                    "Este campo es obligatorio.");

        if (personalDeControl.getPueblo().trim().equals(""))
            errors.rejectValue("pueblo", "obligatorio",
                    "Este campo es obligatorio.");

        if (personalDeControl.getArea().trim().equals(""))
            errors.rejectValue("area", "obligatorio",
                    "Este campo es obligatorio.");

    }
}
