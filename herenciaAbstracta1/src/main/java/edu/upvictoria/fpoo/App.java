package edu.upvictoria.fpoo;

import edu.upvictoria.fpoo.Usuarios.Bibliotecario;
import edu.upvictoria.fpoo.Usuarios.Estudiante;
import edu.upvictoria.fpoo.Usuarios.Maestro;
import edu.upvictoria.fpoo.Usuarios.Usuario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    private static Menu menu = new Menu();

    public static void main(String[] args) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        Usuario usuario = null;
        Menu menu1 = new Menu();

        System.out.println("1) Estudiante");
        System.out.println("2) Maestro");
        System.out.println("3) Bibliotecario");
        int opc = Integer.parseInt(bufer.readLine());

        switch (opc) {
            case 1:
                usuario = new Estudiante();

                break;
            case 2:
                usuario = new Maestro();
                break;
            case 3:
                usuario = new Bibliotecario();
                break;
            default:
                System.out.println("Opción no válida");
                return;
        }
        menu.Seleccion_menu(usuario);
    }

}
