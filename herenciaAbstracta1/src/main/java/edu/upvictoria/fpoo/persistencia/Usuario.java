package edu.upvictoria.fpoo.persistencia;

public class Usuario {
    private int id;
    private String nombre;
    private Object tipo_us;

    public Usuario() {
    }

    public Usuario(int id, String nombre, Object tipo_us) {
        this.id = id;
        this.nombre = nombre;
        this.tipo_us = tipo_us;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object getTipo_us() {
        return tipo_us;
    }

    public void setTipo_us(Object tipo_us) {
        this.tipo_us = tipo_us;
    }
}
