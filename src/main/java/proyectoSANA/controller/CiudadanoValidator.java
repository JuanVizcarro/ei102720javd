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
        if (ciudadano.getNombre().trim().equals(""))
            errors.rejectValue("nom", "obligatori",
                    "Cal introduir un valor");
        // Afegeix ací la validació per a Edat > 15 anys
        if (ciudadano.getEdad() <= 15)
            errors.rejectValue("edat", "edat incorrecta","L'edat ha de ser major de 15 per poder participar");
    }
}
