package edu.upvictoria.fpoo.Usuarios;

public abstract class Usuario {
    protected String nombre;
    protected String apellidos;
    protected String contraseña;
    protected int ID;
    protected String tipo;
    public void crearUsuario(String nombre,String apellidos, int ID, String tipo,String contraseña){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.tipo=tipo;
        this.ID=ID;
        this.contraseña=contraseña;
    }
}
