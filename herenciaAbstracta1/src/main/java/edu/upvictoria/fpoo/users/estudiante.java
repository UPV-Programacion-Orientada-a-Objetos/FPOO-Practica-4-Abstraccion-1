package edu.upvictoria.fpoo.users;

import java.util.List;

public class estudiante extends usuario{

    // constructor
    public estudiante (String id, String nombre, String contra, String tipo) {
        setId(id);
        setNombre(nombre);
        setContra(contra);
        setTipo(tipo);
    }

    public estudiante() {

    }

    // metodo buscar bibliotecario
    public estudiante buscarE(List<estudiante> estudiantes, String id, String contrasena) {
        for (estudiante este : estudiantes) {
            if (este.getId().equalsIgnoreCase(id) && este.getContra().equalsIgnoreCase(contrasena)) {
                System.out.println("usuario encontrado !\n" +
                        este.getNombre() + " | " + este.getContra() + " | " + este.getTipo());
                return este;
            }
        }
        return null;
    }

}
