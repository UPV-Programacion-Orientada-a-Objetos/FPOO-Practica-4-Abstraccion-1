package edu.upvictoria.fpoo.users;

abstract class usuario {

    private String nombre;
    private String contra;
    private String tipo;
    private String id;

    public String getContra() {
        return contra;
    }
    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


}
