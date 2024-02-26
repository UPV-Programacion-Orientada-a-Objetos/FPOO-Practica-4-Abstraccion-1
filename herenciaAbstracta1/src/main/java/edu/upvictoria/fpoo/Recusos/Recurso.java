package edu.upvictoria.fpoo.Recusos;

import java.io.*;

public abstract class Recurso {
    protected  String titulo;
    protected String autor;
    protected int ID;
    protected String tipo;

    public void CrearRecurso(String titulo,String autor,String tipo1, int ID){
        this.autor=autor;
        this.titulo=titulo;
        this.ID=ID;
        this.tipo= tipo1;
    }
    public void insertarRecurso(){
        String archivo="src/main/Resources/RECURSOS.csv";
        try(BufferedWriter wr=new BufferedWriter(new FileWriter(archivo, true))){
            wr.write(ID+"\t"+autor+"\t"+titulo+"\t"+tipo);
            wr.newLine();
        }catch(IOException e){
        }
    }

}
