package edu.upvictoria.fpoo.users;

import java.util.List;

public class profesor extends usuario{

    // constructor
    public profesor (String id, String nombre, String contra, String tipo) {
        setId(id);
        setNombre(nombre);
        setContra(contra);
        setTipo(tipo);
    }

    public profesor() {

    }

    // metodo buscar bibliotecario
    public profesor buscarP(List<profesor> profesores, String id, String contrasena) {
        for (profesor este : profesores) {
            if (este.getId().equalsIgnoreCase(id) && este.getContra().equalsIgnoreCase(contrasena)) {
                System.out.println("usuario encontrado !\n" +
                        este.getNombre() + " | " + este.getContra() + " | " + este.getTipo());
                return este;
            }
        }
        return null;
    }

}
