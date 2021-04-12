package proyectoSANA.model;

public class Municipio {
    private String nom;
    private int telefono;
    private int cp;

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public Municipio() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "nom='" + nom + '\'' +
                ", telefono=" + telefono +
                ", cp=" + cp +
                '}';
    }
}