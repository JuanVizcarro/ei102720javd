package proyectoSANA.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class FechaEstacional {
    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public LocalDate getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(LocalDate fechainicio) {
        this.fechainicio = fechainicio;
    }

    public LocalDate getFechafin() {
        return fechafin;
    }

    public void setFechafin(LocalDate fechafin) {
        this.fechafin = fechafin;
    }

    private String servicio;
    private String area;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate fechainicio = LocalDate.now();
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate fechafin = LocalDate.now();


    public FechaEstacional(){}


    //Devolucion por pantalla, toString
    @Override
    public String toString() {
        return "FechaEstacional{" +
                "Servicio: " + servicio + ", " +
                "Area: " + area + ", " +
                "FechaInicio: " + fechainicio + ", " +
                "FechaFin: " + fechafin +
                '}';
    }
}
