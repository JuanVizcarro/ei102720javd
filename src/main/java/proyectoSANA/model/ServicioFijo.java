package proyectoSANA.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class ServicioFijo {
    private String nombre;
    private String descripcion;

    public ServicioFijo(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    //Devolucion por pantalla, toString
    @Override
    public String toString() {
        return "ServicioFijo{" +
                "Nombre: " + nombre + ", " +
                "Descripcion: " + descripcion +
                '}';
    }
}
