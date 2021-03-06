package proyectoSANA.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    private String numeroReserva;
    private String persona;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate fecha = LocalDate.now();
    private int numeroPersonas;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horaInicio = LocalTime.now();
    private LocalTime horaFin = LocalTime.now();
    private int limiteReserva = 10;
    private String area;
    private String zona;
    private String horarioReserva = "no sirve";

    public Reserva() {}

    public String getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(String numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public LocalTime getHoraInicio() { return horaInicio; }

    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }

    public LocalTime getHoraFin() { return horaFin; }

    public void setHoraFin(LocalTime horaFin) { this.horaFin = horaFin; }

    public int getLimiteReserva() {
        return limiteReserva;
    }

    public void setLimiteReserva(int limiteReserva) {
        this.limiteReserva = limiteReserva;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
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
                "numeroReserva=" + numeroReserva +
                ", persona='" + persona + '\'' +
                ", fecha=" + fecha +
                ", numeroPersonas=" + numeroPersonas +
                ", limiteReserva=" + limiteReserva +
                ", area='" + area + '\'' +
                ", zona='" + zona + '\'' +
                ", horarioReserva=" + horarioReserva +
                '}';
    }
}
