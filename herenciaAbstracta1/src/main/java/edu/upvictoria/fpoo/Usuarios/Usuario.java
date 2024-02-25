package edu.upvictoria.fpoo.Usuarios;

public abstract class Usuario {
    protected String nombre;
    protected String apellidos;
    protected int ID;
    protected String tipo;
    public void crearUsuario(String nombre,String apellidos, int ID, String tipo){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.tipo=tipo;
        this.ID=ID;
    }
}
