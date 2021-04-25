package proyectoSANA.model;

public class Zona {
    private int numero;
    private String area;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Zona() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
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
