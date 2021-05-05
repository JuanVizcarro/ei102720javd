package proyectoSANA.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import proyectoSANA.model.Area;

public class AreaValidator implements Validator {

    @Override
    public boolean supports(Class<?> cls) {
        return Area.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Area area = (Area) obj;
        if (area.getMunicipio().trim().equals(""))
            errors.rejectValue("municipio", "obligatorio",
                    "Este campo es obligatorio.");

        if (area.getTipoAcceso().trim().equals(""))
            errors.rejectValue("tipo acceso", "obligatorio",
                    "Este campo es obligatorio.");

        if (area.getDescripcion().trim().equals(""))
            errors.rejectValue("descripcion", "obligatorio",
                    "Este campo es obligatorio.");

        if (area.getNumeroDeZonas() == 0)
            errors.rejectValue("numero de zonas", "obligatorio",
                    "Este campo es obligatorio.");

        if (area.getNombre().trim().equals(""))
            errors.rejectValue("nombre", "obligatorio",
                    "Este campo es obligatorio.");

        if (area.getUbicacionGeografica().trim().equals(""))
            errors.rejectValue("ubicacion geografica", "obligatorio",
                    "Este campo es obligatorio.");

        if (area.getTipoArea().trim().equals(""))
            errors.rejectValue("tipo area", "obligatorio",
                    "Este campo es obligatorio.");
    }
}
