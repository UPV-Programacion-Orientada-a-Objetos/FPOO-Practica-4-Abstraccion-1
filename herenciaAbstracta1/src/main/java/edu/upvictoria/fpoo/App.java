package edu.upvictoria.fpoo;

import edu.upvictoria.fpoo.Recursos.Diario;
import edu.upvictoria.fpoo.Recursos.Libro;
import edu.upvictoria.fpoo.Recursos.Otro;
import edu.upvictoria.fpoo.Recursos.Revistas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App
{
    public static void main( String[] args ) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Buscar recuros de: ");
        System.out.println("1)Libro");
        System.out.println("2)Diario");
        System.out.println("3)revista");
        System.out.println("4)Otro");
        int opc= Integer.parseInt(bufer.readLine());
        Boolean buscar = false;
        switch (opc){
            case 1:
                Libro libro = new Libro();
                buscar=libro.BuscarRecursoTitulo(libro);
                break;
            case 2:
                Diario diario = new Diario();
                buscar=diario.BuscarRecursoTitulo(diario);
                break;
            case 3:
                Revistas revista = new Revistas();
                buscar=revista.BuscarRecursoTitulo(revista);
                break;
            case 4:
                Otro otro = new Otro();
                buscar=otro.BuscarRecursoTitulo(otro);
                break;
            default:
                System.out.println("opcion no valida");
        }
        if (buscar==false){
            System.out.println("no se encontro el recurso");
        }
    }
}
