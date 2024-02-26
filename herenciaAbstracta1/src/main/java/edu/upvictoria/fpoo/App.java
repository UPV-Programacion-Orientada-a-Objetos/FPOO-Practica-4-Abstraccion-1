package edu.upvictoria.fpoo;

import edu.upvictoria.fpoo.Recursos.Libro;
import edu.upvictoria.fpoo.Recursos.Revistas;
import edu.upvictoria.fpoo.Usuarios.Estudiante;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App
{
    public static void main( String[] args ) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("ELiminar recurso");
        Libro libro = new Libro();
        libro.setNum_id("1");
        libro.EliminarRecurso(libro);

        System.out.println("Editar recurso: ");
        Revistas revistas= new Revistas();
        revistas.setNum_id("1");
        revistas.Modificar_Recurso(revistas);
    }
}
