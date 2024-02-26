package edu.upvictoria.fpoo;

import edu.upvictoria.fpoo.Logica.Prestamos;
import edu.upvictoria.fpoo.Recursos.Diario;
import edu.upvictoria.fpoo.Recursos.Libro;
import edu.upvictoria.fpoo.Recursos.Otro;
import edu.upvictoria.fpoo.Recursos.Revistas;
import edu.upvictoria.fpoo.Usuarios.Bibliotecario;
import edu.upvictoria.fpoo.Usuarios.Estudiante;
import edu.upvictoria.fpoo.Usuarios.Maestro;
import edu.upvictoria.fpoo.Usuarios.Usuario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    public void Seleccion_menu(Usuario usuario) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));

        boolean repetirSeleccion;
        do {
            repetirSeleccion = false;

            if (usuario.getTipo_us().equals("Bibliotecario")) {
                Menu_Bibliotecario();
            } else {
                Menu_usuarios();
            }

            int opc = Integer.parseInt(bufer.readLine());

            switch (opc) {
                case 1:
                    AgregarUsuario();
                    break;
                case 2:
                    Buscar_Recursos();
                    break;
                case 3:
                    Prestamos prestamos = new Prestamos();
                    Otro recurso = new Otro();
                    prestamos.prestar(recurso, usuario);
                    break;
                case 4:
                    AgregarMaterial();
                    break;
                case 5:
                    Modificar_Recursos();
                    break;
                case 6:
                    Eliminar_Recursos();
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
            System.out.println("¿Desea realizar otra operación? (1.- si)");
            String respuesta = bufer.readLine();
            if (respuesta.equalsIgnoreCase("1")) {
                repetirSeleccion = true;
            }

        } while (repetirSeleccion);
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

    public void AgregarUsuario() throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
            int opc =0;
                    System.out.println("registro de: ");
                    System.out.println("1)estudiante");
                    System.out.println("2)Maestro");
                    System.out.println("3)Bibliotecario");
                    opc = Integer.parseInt(bufer.readLine());
                    switch (opc) {
                        case 1:
                            Estudiante estudiante = new Estudiante();
                            estudiante.NuevoEstudiante(estudiante);
                            break;
                        case 2:
                            Maestro maestro = new Maestro();
                            maestro.NuevoMaestro(maestro);
                            break;
                        case 3:
                            Bibliotecario bibliotecario = new Bibliotecario();
                            bibliotecario.NuevoBibliotecario(bibliotecario);
                            break;
                        default:
                            System.out.println("opcion no valida");
                        }
    }
    public void Buscar_Recursos()throws IOException{
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1) Buscar por titulo");
        System.out.println("2) Buscar por autor");
        int opc=Integer.parseInt(bufer.readLine());
        if (opc==1){
            System.out.println("Buscar recuros de: ");
            System.out.println("1)Libro");
            System.out.println("2)Diario");
            System.out.println("3)revista");
            System.out.println("4)Otro");
            opc= Integer.parseInt(bufer.readLine());
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
        else if (opc==2) {
            System.out.println("1)Libro");
            System.out.println("2)Diario");
            System.out.println("3)revista");
            opc= Integer.parseInt(bufer.readLine());
                switch (opc){
                    case 1:
                        Libro libro = new Libro();
                        libro.BuscarRecursoAutor(libro);
                        break;
                    case 2:
                        Diario diario = new Diario();
                        diario.BuscarRecursoAutor(diario);
                        break;
                    case 3:
                        Revistas revista = new Revistas();
                        revista.BuscarRecursoAutor(revista);
                        break;
                    case 4:
                        Otro otro = new Otro();
                        otro.BuscarRecursoAutor(otro);
                        break;
                    default:
                        System.out.println("opcion no valida");
                }
        }else {
            System.out.println("Opcion no valida");
        }
    }

    public void Modificar_Recursos() throws IOException{
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
                libro.Modificar_Recurso(libro);
                break;
            case 2:
                Diario diario = new Diario();
                diario.Modificar_Recurso(diario);
                break;
            case 3:
                Revistas revista = new Revistas();
                revista.Modificar_Recurso(revista);
                break;
            case 4:
                Otro otro = new Otro();
                otro.Modificar_Recurso(otro);
                break;
            default:
                System.out.println("opcion no valida");
        }
    }

    public void Eliminar_Recursos() throws IOException{
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
                libro.EliminarRecurso(libro);
                break;
            case 2:
                Diario diario = new Diario();
                diario.EliminarRecurso(diario);
                break;
            case 3:
                Revistas revista = new Revistas();
                revista.EliminarRecurso(revista);
                break;
            case 4:
                Otro otro = new Otro();
                otro.EliminarRecurso(otro);
                break;
            default:
                System.out.println("opcion no valida");
        }
    }



}