package edu.upvictoria.fpoo.Recusos;

public abstract class Recurso {
    protected  String titulo;
    protected String autor;
    protected int ID;
    protected String tipo;

    public void CrearRecurso(String titulo,String autor,String tipo, int ID){
        this.autor=autor;
        this.tipo=titulo;
        this.ID=ID;
        this.tipo= tipo;
    }
}
