package proyectoSANA.model;

public class Ciudadano {
    private String nombre;
    private String DNI;
    private String email;
    private String direccion;
    private String municipio;
    private String pais;

    public Ciudadano(){

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getPais() {
        return pais;
    }
    @Override
    public String toString() {
        return "Ciudadano{" +
                "nombre='" + nombre + '\'' +
                ", DNI=" + DNI +
                ", email=" + email +
                ", direccion=" + direccion +
                ", municipio=" + municipio +
                ", pais=" + pais +
                '}';
    }
}
