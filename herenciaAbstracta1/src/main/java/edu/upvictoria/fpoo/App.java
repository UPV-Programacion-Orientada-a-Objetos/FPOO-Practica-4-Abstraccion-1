package edu.upvictoria.fpoo;
import edu.upvictoria.fpoo.Logica.Prestamos;
import edu.upvictoria.fpoo.Recursos.Libro;
import edu.upvictoria.fpoo.Recursos.Otro;
import edu.upvictoria.fpoo.Usuarios.Estudiante;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App
{
    public static void main( String[] args ) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        Estudiante estudiante = new Estudiante();
        Menu menu = new Menu();
        Prestamos prestamos = new Prestamos();
        estudiante.setId("1234");
        estudiante.setNombre("cinthia");
        System.out.println("3)Prestamo de recursos");
        Otro recurso= new Otro();
        prestamos.prestar(recurso,estudiante);

    }
}
