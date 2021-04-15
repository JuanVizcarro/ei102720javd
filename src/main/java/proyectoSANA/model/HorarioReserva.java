package proyectoSANA.model;

import java.sql.Time;

public class HorarioReserva {
    private Time horaInicio;
    private Time horaFin;
    private String temporada;

    public HorarioReserva() {
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    @Override
    public String toString() {
        return "HorarioReserva{" +
                "horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                ", temporada='" + temporada + '\'' +
                '}';
    }
}
