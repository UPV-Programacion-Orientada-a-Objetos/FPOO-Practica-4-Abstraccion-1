package edu.upvictoria.fpoo;

import edu.upvictoria.fpoo.persistencia.Bibliotecario;
import edu.upvictoria.fpoo.persistencia.Estudiante;
import edu.upvictoria.fpoo.persistencia.Maestro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App
{
    public static void main( String[] args ) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("busqueda de: ");
        System.out.println("1)estudiante");
        System.out.println("2)Maestro");
        System.out.println("3)Bibliotecario");
        int opc= Integer.parseInt(bufer.readLine());
        switch (opc){
            case 1:
                Estudiante estudiante = new Estudiante();
                estudiante.buscarUsuario(estudiante);

                break;
            case 2:
                Maestro maestro = new Maestro();
                maestro.buscarUsuario(maestro);
                break;
            case 3:
                Bibliotecario bibliotecario = new Bibliotecario();
                bibliotecario.buscarUsuario(bibliotecario);
                break;
            default:
                System.out.println("opcion no valida");
        }
    }
}
