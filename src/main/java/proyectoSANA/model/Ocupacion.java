package proyectoSANA.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class Ocupacion {
    public int getNormal() {
        return normal;
    }

    public void setNormal(int normal) {
        this.normal = normal;
    }

    private int normal;
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    private String area;
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate fecha = LocalDate.now();

    public Ocupacion() {}
}
