package proyectoSANA.controller;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import proyectoSANA.model.Ciudadano;

import java.util.Arrays;
import java.util.List;

public class CiudadanoValidator implements Validator {
    @Override
    public boolean supports(Class<?> cls) {
        return Ciudadano.class.equals(cls);
        // o, si volguérem tractar també les subclasses:
        // return Nadador.class.isAssignableFrom(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Ciudadano ciudadano = (Ciudadano)obj;
        if (ciudadano.getUsuario().trim().equals(""))
            errors.rejectValue("usuario", "obligatori",
                    "Es necesario introducir un valor");
        if (ciudadano.getDNI().trim().equals(""))
            errors.rejectValue("DNI", "obligatori",
                    "Es necesario introducir un valor");
        if (ciudadano.getEmail().trim().equals(""))
            errors.rejectValue("email", "obligatori",
                    "Es necesario introducir un valor");
        if (ciudadano.getEdad()==0)
            errors.rejectValue("edad", "obligatori",
                    "Es necesario introducir un valor");
    }
}
