package proyectoSANA.model;

import java.util.Date;

public class Reserva {
    private String persona;
    private Date fecha;
    private int numeroPersonas;
    private String qr;
    private int limiteReserva;
    private String area;
    private String zona;
    private String horarioReserva; //Cambiar String por tipo: HorarioReserva

    public Reserva() {}

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public int getLimiteReserva() {
        return limiteReserva;
    }

    public void setLimiteReserva(int limiteReserva) {
        this.limiteReserva = limiteReserva;
    }

    public String getArea() { // Cambiar String por Area
        return area;
    }

    public void setArea(String area) { // Cambiar String por Area
        this.area = area;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getHorarioReserva() {
        return horarioReserva;
    }

    public void setHorarioReserva(String horarioReserva) {
        this.horarioReserva = horarioReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "persona=" + persona +
                ", fecha=" + fecha +
                ", numeroPersonas=" + numeroPersonas +
                ", qr='" + qr + '\'' +
                ", limiteReserva=" + limiteReserva +
                ", area=" + area +
                ", zona=" + zona +
                ", horarioReserva=" + horarioReserva +
                '}';
    }
}
