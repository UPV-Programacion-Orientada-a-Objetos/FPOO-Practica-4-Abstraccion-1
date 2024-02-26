package edu.upvictoria.fpoo;

import edu.upvictoria.fpoo.Usuarios.Estudiante;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App
{
    public static void main( String[] args ) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        boolean borrado= false;
        System.out.println("eliminar usuario");
        Estudiante estudiante1 = new Estudiante();
        estudiante1.setId("2213");
        borrado=estudiante1.eliminarUsuario(estudiante1);
        if (borrado==true){
            System.out.println("usuario eliminado.");
        }

    }
}
