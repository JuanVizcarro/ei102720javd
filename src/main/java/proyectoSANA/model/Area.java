package proyectoSANA.model;

public class Area {

    private String municipio;
    private String tipoAcceso;
    private String descripcion;
    private int numeroZonas;
    private String nombre;
    private String ubicacionGeográfica;
    private String orientacion;
    private String instalacion;
    private String comentarios;

    public Area(){

    }
    public String getMunicipio(){
        return municipio;
    }
    public String getTipoAcceso(){
        return tipoAcceso;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public int getNumeroZonas(){
        return numeroZonas;
    }
    public String getNombre(){
        return nombre;
    }
    public String getUbicacionGeográfica(){
        return ubicacionGeográfica;
    }
    public String getOrientacion(){
        return orientacion;
    }
    public String getInstalacion(){
        return instalacion;
    }
    public String getComentarios(){
        return comentarios;
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
    public void setNumeroZonas(int numeroZonas){
        this.numeroZonas = numeroZonas;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setUbicacionGeográfica(String ubicacionGeográfica){
        this.ubicacionGeográfica = ubicacionGeográfica;
    }
    public void setOrientacion(String orientacion){
        this.orientacion = orientacion;
    }
    public void setInstalacion(String instalacion){
        this.instalacion = instalacion;
    }
    public void setComentarios(String comentarios){
        this.comentarios = comentarios;
    }

}
