package edu.upvictoria.fpoo.Usuarios;

import java.io.*;

public abstract class Usuario {
    protected String nombre;
    protected String apellidos;
    protected String contraseña;
    protected int ID;
    protected String tipo;
    public void crearUsuario(String nombre,String apellidos, int ID,String tipous,String contraseña){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.ID=ID;
        this.contraseña=contraseña;
        this.tipo=tipous;
    }
    public void insertarUsuario(){
        String archivo="src/main/Resources/USD.csv";
        try(BufferedWriter wr=new BufferedWriter(new FileWriter(archivo, true))){
            wr.write(ID+"\t"+nombre+"\t"+apellidos+"\t"+contraseña+"\t"+tipo);
            wr.newLine();
        }catch(IOException e){
        }
    }



}
