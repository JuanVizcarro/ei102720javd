package proyectoSANA.model;

public class UserDetails {
    String username;
    String password;
    String tipo;

    public String getUsername() {
        return username;
    }

    public boolean setUsername(String username) {
        this.username = username;
        return true;
    }
    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        this.password = password;
        return true;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean setTipo(String tipo) {
        this.tipo = tipo;
        return true;
    }
}

