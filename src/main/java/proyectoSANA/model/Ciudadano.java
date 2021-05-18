package proyectoSANA.model;

public class Ciudadano {
    private String usuario;
    private String contraseña;
    private String DNI;
    private String email;
    private int edad;
    private String direccion;
    private String municipio;
    private String pais;

    public Ciudadano(){

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }
    @Override
    public String toString() {
        return "Ciudadano{" +
                "usuario='" + usuario + '\'' +
                ", contraseña=" + contraseña +
                ", DNI=" + DNI +
                ", email=" + email +
                ", edad= " + edad +
                ", direccion=" + direccion +
                ", municipio=" + municipio +
                ", pais=" + pais +
                '}';
    }
}
