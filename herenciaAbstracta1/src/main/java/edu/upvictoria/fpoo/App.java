package edu.upvictoria.fpoo;
import edu.upvictoria.fpoo.Usuarios.Estudiante;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App
{
    public static void main( String[] args ) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Editar Usuario: ");
        Estudiante estudiante= new Estudiante();
        estudiante.setId("1");
        estudiante.ModificarUsuario(estudiante);
    }
}
