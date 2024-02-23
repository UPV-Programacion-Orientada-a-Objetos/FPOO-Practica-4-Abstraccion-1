package edu.upvictoria.fpoo.users;

import java.util.List;

public class bibliotecario extends usuario{

    // atributos
    private int maxMaterial = 5;
    private int cantPrestamos = 0;
    private String apellidos;

    // constructor
    public bibliotecario (String id, String nombre, String contra, String tipo) {
        setId(id);
        setNombre(nombre);
        setContra(contra);
        setTipo(tipo);
    }

    public bibliotecario() {

    }

    // metodo buscar bibliotecario
    public bibliotecario buscarB(List<bibliotecario> bibliotecarios, String id, String contrasena) {
        for (bibliotecario este : bibliotecarios) {
            if (este.getId().equalsIgnoreCase(id) && este.getContra().equalsIgnoreCase(contrasena)) {
                System.out.println("usuario encontrado !\n" +
                        este.getNombre() + " | " + este.getContra() + " | " + este.getTipo());
                return este;
            }
        }
        return null;
    }



}
