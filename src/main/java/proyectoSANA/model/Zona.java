package proyectoSANA.model;

public class Zona {
    private String numero;
    private String area;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Zona() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Zona{" +
                "numero=" + numero +
                ", area='" + area + '\'' +
                '}';
    }
}
