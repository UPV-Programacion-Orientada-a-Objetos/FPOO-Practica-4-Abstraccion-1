package edu.upvictoria.fpoo.recursos;

abstract class recurso {

    private String titulo;
    private String autor;
    private String id;
    private String tipo;

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

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
