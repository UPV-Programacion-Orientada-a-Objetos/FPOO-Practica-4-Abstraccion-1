package edu.upvictoria.fpoo.Recursos;

public abstract class Recurso {
    //título, autor o número de identificación,
    private String titulo;
    private String autor;
    private String num_id;
    private String tipo;

    public Recurso() {
    }

    public Recurso(String titulo, String autor, String num_id, String tipo) {
        this.titulo = titulo;
        this.autor = autor;
        this.num_id = num_id;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNum_id() {
        return num_id;
    }

    public void setNum_id(String num_id) {
        this.num_id = num_id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
