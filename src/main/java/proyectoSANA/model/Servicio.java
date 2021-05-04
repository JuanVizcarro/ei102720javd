package proyectoSANA.model;

import java.sql.Date;
import java.sql.Time;

public class Servicio {
    private String identificador;
    private String nombre;
    private String descripcion;
    private String tipo;
    private String area;
    private int numero;
    private Date fechaInicio;
    private Date fechaFin;

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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
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
