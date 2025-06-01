package es.ieslavereda.proyecto2425_servidor.repository.model;

public class Usuario {
    
    private int idUsuario, oficio_idOficio;
    private String nombre, apellidos;
    
    public Usuario(int idUsuario, String nombre, String apellidos, int oficio_idOficio){
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.oficio_idOficio = oficio_idOficio;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public int getOficio_idOficio() {
        return oficio_idOficio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }



}
