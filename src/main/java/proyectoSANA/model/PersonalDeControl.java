package proyectoSANA.model;

public class PersonalDeControl {
    private String dni;
    private String email;
    private String nombre;
    private String pueblo;
    private String area;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPueblo() {
        return pueblo;
    }

    public void setPueblo(String pueblo) {
        this.pueblo = pueblo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "PersonalDeControl{" +
                "dni='" + dni + '\'' +
                ",email=" + email +
                ", nombre=" + nombre +
                ", pueblo=" + pueblo +
                ", area=" + area +
                '}';
    }
}
