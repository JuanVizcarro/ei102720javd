package proyectoSANA.model;

import java.util.Date;

public class GestorMunicipal {

    private String DNI;
    private String nombre;
    private String pueblo;
    private Date fechaInicio;
    private Date fechaFin;

    public GestorMunicipal(){

    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPueblo() {
        return pueblo;
    }

    public void setPueblo(String pueblo) {
        this.pueblo = pueblo;
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

    @Override
    public String toString() {
        return "GestorMunicipal{" +
                "DNI='" + DNI + '\'' +
                ", nombre=" + nombre +
                ", pueblo=" + pueblo +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +

                '}';
    }
}
