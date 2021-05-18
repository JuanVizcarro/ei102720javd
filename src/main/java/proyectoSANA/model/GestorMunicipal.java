package proyectoSANA.model;

import java.util.Date;

public class GestorMunicipal {

    private String DNI;
    private String usuario;
    private String contraseña;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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
                ", usuario=" + usuario +
                ", contraseña=" + contraseña +
                ", pueblo=" + pueblo +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +

                '}';
    }
}
