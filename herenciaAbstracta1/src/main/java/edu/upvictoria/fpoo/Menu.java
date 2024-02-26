package edu.upvictoria.fpoo;

import edu.upvictoria.fpoo.Logica.Prestamos;
import edu.upvictoria.fpoo.Recursos.Diario;
import edu.upvictoria.fpoo.Recursos.Libro;
import edu.upvictoria.fpoo.Recursos.Otro;
import edu.upvictoria.fpoo.Recursos.Revistas;
import edu.upvictoria.fpoo.Usuarios.Usuario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    public void Seleccion_menu(Usuario usuario) throws IOException{
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        if (usuario.getTipo_us().equals("Bibliotecario")){
            Menu_Bibliotecario();
            int opc= Integer.parseInt(bufer.readLine());
            switch (opc){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:

            }
        }else {
            Menu_usuarios();
            int opc= Integer.parseInt(bufer.readLine());
            switch (opc){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    Prestamos prestamos = new Prestamos();
                    Otro recurso= new Otro();
                    prestamos.prestar(recurso,usuario);
                    break;
                default:
            }
        }


    }
    public void Menu_usuarios(){

        System.out.println("1)Registrar usuario");
        System.out.println("2)Buscar recursos");//que tipo? de que modo?
        System.out.println("3)Prestamo de recursos");
    }
    public void Menu_Bibliotecario(){
        Menu_usuarios();
        System.out.println("4)Agregar recursos");
        System.out.println("5)Modificar recursos");
        System.out.println("6)Eliminar recursos");
    }
    public void AgregarMaterial()throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Agregar recuros de: ");
        System.out.println("1)Libro");
        System.out.println("2)Diario");
        System.out.println("3)revista");
        System.out.println("4)Otro");
        int opc= Integer.parseInt(bufer.readLine());
        switch (opc){
            case 1:
                Libro libro = new Libro();
                libro.NuevoLibro(libro);
                break;
            case 2:
                Diario diario = new Diario();
                diario.NuevoDiario(diario);
                break;
            case 3:
                Revistas revista = new Revistas();
                revista.NuevaRevista(revista);
                break;
            case 4:
                Otro otro = new Otro();
                otro.NuevoRecurso(otro);
                break;
            default:
                System.out.println("opcion no valida");}
    }

    public void AgregarUsuario() throws IOException{

    }

}
