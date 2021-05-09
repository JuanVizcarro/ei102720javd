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

        if (servicio.getFechaInicio() == null) // fecha ini debe ser menor que fecha fin
            errors.rejectValue("fechaInicio", "obligatorio",
                    "Este campo es obligatorio.");

        if (servicio.getFechaFin() == null) // fecha fin debe ser mayor que fecha ini
            errors.rejectValue("fechaInicio", "obligatorio",
                    "Este campo es obligatorio.");

    }
}

   /* identificador		VARCHAR(10)	NOT NULL,
    nombre		VARCHAR(10)	NOT NULL,
    descripcion		VARCHAR(100)	,
    tipo			VARCHAR(50)	NOT NULL,
    area			VARCHAR(50)	NOT NULL,
    numero		NUMERIC(5)		NOT NULL,
    fechaInicio		DATE			NOT NULL,
    fechaFin		DATE			NOT NULL,

    */