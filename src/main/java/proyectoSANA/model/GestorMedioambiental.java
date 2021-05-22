package proyectoSANA.model;

import java.util.Date;

public class GestorMedioambiental {

    private String DNI;
    private String usuario;
    private String contraseña;

    public GestorMedioambiental(){

    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
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

    @Override
    public String toString() {
        return "GestorMunicipal{" +
                "DNI='" + DNI + '\'' +
                ", usuario=" + usuario +
                ", contraseña=" + contraseña +
                '}';
    }
}
