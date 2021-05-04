package proyectoSANA.model;

import java.sql.Time;

public class Servicio {
    private String identificador;
    private String nombre;
    private String descripcion;
    private String tipo;
    private String area;
    private int numero;
    private Time fechaInicio;
    private Time fechaFin;

    public Servicio(){}

    //Metodos de devolucion de datos, getters
    public String getIdentificador(){ return identificador;}
    public String getNombre(){ return nombre;}
    public String getDescripcion(){ return descripcion;}
    public String getTipo(){ return tipo;}
    public String getArea(){ return area;}
    public int getNumero(){ return numero;}
    public Time getFechaInicio(){ return fechaInicio;}
    public Time getFechaFin(){ return fechaFin;}

    //Metodos de introduccion de datos, setters
    public boolean setNombre(String nombre){this.nombre = nombre; return true;}
    public boolean setDescripcion(String descripcion){this.descripcion = descripcion; return true;}
    public boolean setTipo(String tipo){this.tipo = tipo; return true;}
    public boolean setArea(String area){this.area = area; return true;}
    public boolean setNumero(int numero){this.numero = numero; return true;}
    public boolean setFechaInicio(Time fecha){this.fechaInicio = fecha; return true;}
    public boolean setFechaFin(Time fecha){this.fechaFin = fecha; return true;}

    //Devolucion por pantalla, toString
    @Override
    public String toString() {
        return "Area{" +
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
