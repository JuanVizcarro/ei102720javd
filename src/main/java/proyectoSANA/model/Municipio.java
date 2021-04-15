package proyectoSANA.model;

public class Municipio {
    private String nombre;
    private int tlf;
    private int cp;

    public Municipio() {
    }

    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "nombre='" + nombre + '\'' +
                ", tlf=" + tlf +
                ", cp=" + cp +
                '}';
    }
}