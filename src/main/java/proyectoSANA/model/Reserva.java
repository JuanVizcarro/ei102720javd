package proyectoSANA.model;

import java.util.Date;

public class Reserva {
    private Ciudadano persona;
    private Date fecha;
    private int numeroPersonas;
    private String qr;
    private int limiteReserva;
   // private Area area;
    private Zona zona;
    private HorarioReserva horarioReserva;

    public Reserva() {}

    public Ciudadano getPersona() {
        return persona;
    }

    public void setPersona(Ciudadano persona) {
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

  /*  public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
*/
    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public HorarioReserva getHorarioReserva() {
        return horarioReserva;
    }

    public void setHorarioReserva(HorarioReserva horarioReserva) {
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
            //    ", area=" + area +
                ", zona=" + zona +
                ", horarioReserva=" + horarioReserva +
                '}';
    }
}
