package edu.upvictoria.fpoo.recursos;

import edu.upvictoria.fpoo.users.estudiante;

import java.util.List;

public class libro extends recurso{

    // constuctor
    public libro(String titulo, String autor, String id, String tipo) {
        setTitulo(titulo);
        setAutor(autor);
        setId(id);
        setTipo(tipo);
    }
    public libro() {

    }

    // metodo buscar bibliotecario
    public libro buscarLibro(List<libro> libros, String id, String titulo) {
        for (libro este : libros) {
            if (este.getId().equalsIgnoreCase(id) && este.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("libro encontrado !\n" +
                        este.getTitulo() + " | " + este.getId() + " | " + este.getAutor());
                return este;
            }
        }
        return null;
    }

}
