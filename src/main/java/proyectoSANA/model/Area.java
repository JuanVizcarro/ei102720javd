package proyectoSANA.model;

public class Area {

    private String municipio;
    private String tipoAcceso;
    private String descripcion;
    private int numeroDeZonas;
    private String nombre;
    private String ubicacionGeografica;
    private String tipoArea;
    private String caracteristicaFisica;
    private String orientacion;
    private String instalacion;
    private String comentario;
    private String imagen;

    public Area(){

    }
    public String getTipoArea() { return tipoArea; }
    public void setTipoArea(String tipoArea) { this.tipoArea = tipoArea; }
    public String getCaracteristicaFisica() { return caracteristicaFisica; }
    public void setCaracteristicaFisica(String caracteristicaFisica) { this.caracteristicaFisica = caracteristicaFisica; }
    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }
    public String getMunicipio(){
        return municipio;
    }
    public String getTipoAcceso(){
        return tipoAcceso;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public int getNumeroDeZonas(){
        return numeroDeZonas;
    }
    public String getNombre(){
        return nombre;
    }
    public String getUbicacionGeografica(){
        return ubicacionGeografica;
    }
    public String getOrientacion(){
        return orientacion;
    }
    public String getInstalacion(){
        return instalacion;
    }
    public String getComentario(){
        return comentario;
    }
    public void setMunicipio(String municipio){
        this.municipio = municipio;
    }
    public void setTipoAcceso(String tipoAcceso){
        this.tipoAcceso = tipoAcceso;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void setNumeroDeZonas(int numeroDeZonas){
        this.numeroDeZonas = numeroDeZonas;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setUbicacionGeografica(String ubicacionGeografica){
        this.ubicacionGeografica = ubicacionGeografica;
    }
    public void setOrientacion(String orientacion){
        this.orientacion = orientacion;
    }
    public void setInstalacion(String instalacion){
        this.instalacion = instalacion;
    }
    public void setComentario(String comentario){
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Area{" +
                "municipio: " + municipio + "\n" +
                " :" + + ", " +
                " :" + + ", " +
                " :" + + ", " +
                " :" + + ", " +
                " :" + + ", " +
                '}';
    }
    private String municipio;
    private String tipoAcceso;
    private String descripcion;
    private int numeroDeZonas;
    private String nombre;
    private String ubicacionGeografica;
    private String tipoArea;
    private String caracteristicaFisica;
    private String orientacion;
    private String instalacion;
    private String comentario;
    private String imagen;

}
