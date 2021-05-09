package proyectoSANA.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Servicio {
    private String identificador;
    private String nombre;
    private String descripcion;
    private String tipo;
    private String area;
    private int numero;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Servicio(){}

    public String getIdentificador() {
        return identificador;
    }

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    //Devolucion por pantalla, toString
    @Override
    public String toString() {
        return "Servicio{" +
                "Identificador: " + identificador + ", " +
                "Nombre: " + nombre + ", " +
                "Descripcion: " + descripcion + ", " +
                "Tipo: " + tipo + ", " +
                "Area: " + area + ", " +
                "Numero: " + numero + ", " +
                "FechaInicio: " + fechaInicio + ", " +
                "FechaFin: " + fechaFin + ", " +
                '}';
    }
}
