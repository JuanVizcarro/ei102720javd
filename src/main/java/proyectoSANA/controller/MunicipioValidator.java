package proyectoSANA.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import proyectoSANA.model.Municipio;

public class MunicipioValidator implements Validator {

    @Override
    public boolean supports(Class<?> cls) {
        return Municipio.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Municipio municipio = (Municipio) obj;
        if (municipio.getNombre().trim().equals(""))
            errors.rejectValue("municipio", "obligatorio",
                    "Este campo es obligatorio.");

        if (String.valueOf(municipio.getTlf()).length()!=9)
            errors.rejectValue("tipoAcceso", "obligatorio",
                    "Este campo debe tener 9 dígitos.");

        if (String.valueOf(municipio.getCp()).length()!=5)
            errors.rejectValue("descripcion", "obligatorio",
                    "Este campo debe tener 5 dígitos.");

    }
}
