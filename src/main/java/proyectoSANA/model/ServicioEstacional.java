package proyectoSANA.model;

public class ServicioEstacional {
    private String nombre;
    private String descripcion;

    public ServicioEstacional(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    //Devolucion por pantalla, toString
    @Override
    public String toString() {
        return "ServicioEstacional{" +
                "Nombre: " + nombre + ", " +
                "Descripcion: " + descripcion +
                '}';
    }
}
