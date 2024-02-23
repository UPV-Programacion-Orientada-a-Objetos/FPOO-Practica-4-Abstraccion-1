package edu.upvictoria.fpoo;

import edu.upvictoria.fpoo.recursos.diario;
import edu.upvictoria.fpoo.recursos.libro;
import edu.upvictoria.fpoo.recursos.revista;
import edu.upvictoria.fpoo.users.bibliotecario;
import edu.upvictoria.fpoo.users.espera;
import edu.upvictoria.fpoo.users.estudiante;
import edu.upvictoria.fpoo.users.profesor;

import java.io.*;
import java.util.List;

public class App
{

    // listas para material
    private List<libro> libros;
    private List<revista> revistas;
    private List<diario> periodicos;

    // listas para usuarios
    private List<bibliotecario> bibliotecarios;
    private List<estudiante> estudiantes;
    private List<profesor> profesores;
    private List<espera> esperaList;

    public static void main( String[] args ) {

        try {

            App app = new App();
            leer_archivo la = new leer_archivo();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {

                // obtener los usuarios
                app.esperaList = la.guardarEspera();
                app.bibliotecarios = la.guardarBibliotecarios();
                app.estudiantes = la.guardarEstudiantes();
                app.profesores = la.guardarProfesores();

                // obtener los recursos
                app.libros = la.guardarLibros();

                System.out.print("\n// bienvenido!" +
                                 "\n\nmatricula:");
                String matricula = reader.readLine();
                char dif = matricula.charAt(0);

                if ('b' == dif && matricula.length() == 5) {

                    System.out.print("contraseña:");
                    String contra = reader.readLine();

                    bibliotecario bib = new bibliotecario();
                    bib = bib.buscarB(app.bibliotecarios, matricula, contra);

                    if (bib != null) {
                        app.menu_bib();
                    } else {
                        System.out.println("[!] usuario no encontrado.");
                    }

                } else if ('e' == dif && matricula.length() == 5) {

                    System.out.print("contraseña:");
                    String contra = reader.readLine();

                    estudiante est = new estudiante();
                    est = est.buscarE(app.estudiantes, matricula, contra);

                    if (est != null) {
                        app.menu_est();
                    } else {
                        System.out.println("[!] usuario no encontrado.");
                    }

                    app.menu_est();

                } else if ('p' == dif && matricula.length() == 5) {

                    System.out.print("contraseña:");
                    String contra = reader.readLine();

                    profesor prof = new profesor();
                    prof = prof.buscarP(app.profesores, matricula, contra);

                    if (prof != null) {
                        app.menu_prof();
                    } else {
                        System.out.println("[!] usuario no encontrado.");
                    }

                    app.menu_prof();

                } else {

                    System.out.print("[!] usuario inexistente, desea agregar un nuevo usuario? (requiere autorizacion) Si[1] No[0]: ");
                    String res = reader.readLine();
                    int r = Integer.parseInt(res);

                    if (r == 1) {
                        app.llenarInfo();
                    } else { break; }


                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // menus
    public void menu_bib() {

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("\nB I B L I O T E C A  E S C O L A R");
            System.out.println("MENU (Bibliotecario)\n");


            int opc = 0;

            while (opc != 6) {

                System.out.println("seleccione una accion.\n");

                System.out.println("1.- Agregar recurso");
                System.out.println("2.- Editar recurso");
                System.out.println("3.- Eliminar recurso");
                System.out.println("4.- Dar de alta usuarios");
                System.out.println("5.- Ver deudores");

                System.out.println("\n6.- Cerrar sesion");

                System.out.print("\nIngrese su eleccion: ");
                String input = reader.readLine();
                opc = Integer.parseInt(input);

                switch (opc) {
                    case 1:
                        //addRecursos();
                        System.out.println("\nPulse enter para salir. ");
                        reader.readLine();
                        break;
                    case 2:
                        //editarRecurso();
                        System.out.println("\nPulse enter para salir. ");
                        reader.readLine();
                        break;
                    case 3:
                        //eliminarRecurso();
                        System.out.println("\nPulse enter para salir. ");
                        reader.readLine();
                        break;
                    case 4:
                        altaUsuario();
                        System.out.println("\nPulse enter para salir. ");
                        reader.readLine();
                        break;
                    case 5:
                        //verDeudores();
                        System.out.println("\nPulse enter para salir. ");
                        reader.readLine();
                        break;
                    case 6:
                        System.out.println("q le vaya bien");
                        return;
                    default:
                        System.out.println("\nIngrese una opcion valida. ");
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void menu_est() {

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("\nB I B L I O T E C A  E S C O L A R");
            System.out.println("MENU (Estudiante)\n");


            int opc = 0;

            while (opc != 5) {

                System.out.println("seleccione una accion.\n");

                System.out.println("1.- Buscar recurso");
                System.out.println("2.- Pedir prestado un recurso");
                System.out.println("3.- Devolver recurso");
                System.out.println("4.- Renovar prestamo");

                System.out.println("\n5.- Cerrar sesion");

                System.out.print("\nIngrese su eleccion: ");
                String input = reader.readLine();
                opc = Integer.parseInt(input);

                switch (opc) {
                    case 1:
                        //addRecursos();
                        System.out.println("\nPulse enter para salir. ");
                        reader.readLine();
                        break;
                    case 2:
                        //editarRecurso();
                        System.out.println("\nPulse enter para salir. ");
                        reader.readLine();
                        break;
                    case 3:
                        //eliminarRecurso();
                        System.out.println("\nPulse enter para salir. ");
                        reader.readLine();
                        break;
                    case 4:
                        altaUsuario();
                        System.out.println("\nPulse enter para salir. ");
                        reader.readLine();
                        break;
                    case 5:
                        System.out.println("q le vaya bien");
                        return;
                    default:
                        System.out.println("\nIngrese una opcion valida. ");
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void menu_prof() {

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("\nB I B L I O T E C A  E S C O L A R");
            System.out.println("MENU (Profesor)\n");


            int opc = 0;

            while (opc != 5) {

                System.out.println("seleccione una accion.\n");

                System.out.println("1.- Buscar recurso");
                System.out.println("2.- Pedir prestado un recurso");
                System.out.println("3.- Devolver recurso");
                System.out.println("4.- Renovar prestamo");

                System.out.println("\n5.- Cerrar sesion");

                System.out.print("\nIngrese su eleccion: ");
                String input = reader.readLine();
                opc = Integer.parseInt(input);

                switch (opc) {
                    case 1:
                        //addRecursos();
                        System.out.println("\nPulse enter para salir. ");
                        reader.readLine();
                        break;
                    case 2:
                        //editarRecurso();
                        System.out.println("\nPulse enter para salir. ");
                        reader.readLine();
                        break;
                    case 3:
                        //eliminarRecurso();
                        System.out.println("\nPulse enter para salir. ");
                        reader.readLine();
                        break;
                    case 4:
                        altaUsuario();
                        System.out.println("\nPulse enter para salir. ");
                        reader.readLine();
                        break;
                    case 5:
                        System.out.println("q le vaya bien");
                        return;
                    default:
                        System.out.println("\nIngrese una opcion valida. ");
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    // metodos para agregar
    public void llenarInfo() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\nEspecifique el tipo de usuario:\n" +
                           "[1] Bibliotecario\n[2] Estudiante\n[3] Profesor");
        String tip = reader.readLine();
        int t = Integer.parseInt(tip);

        String realID = null;
        String tipo = null;

        if (t == 1) { tipo = "Bibliotecario"; }
        else if (t == 2){ tipo = "Estudiante"; }
        else if (t == 3){ tipo = "Profesor"; }
        else { tipo = "error"; }

        if (tipo.equalsIgnoreCase("error")) {

            System.out.println("[!] opcion invalida");

        } else {

            System.out.print("\nnombre:");
            String nombre = reader.readLine();
            System.out.print("contraseña:");
            String password = reader.readLine();

            int id = 0;
            if (!esperaList.isEmpty()) {
                id = Integer.parseInt(esperaList.get(esperaList.size() - 1).getId());
                id = id+1;
                realID = String.valueOf(id);
            }

            espera neoEspera = new espera(realID, nombre, password, tipo);
            esperaList.add(neoEspera);

            String path = "fpoo-practica-4-abstraccion-1-jigglypuff\\bd_listaEspera.csv";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {

                String line = realID + "," + nombre + "," + password + "," + tipo;
                writer.write(line);
                writer.newLine();

                System.out.println("agregado a la lista de espera correctamente, espere a que un bibliotecario lo autorice.");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    // metodos dar de alta
    public void tablaEspera(){

        System.out.println("-----------------------------------------------------------");
        System.out.println("|  ID  | Nombre          | Contraseña      | Tipo          |");
        System.out.println("-----------------------------------------------------------");
        for (espera usuario : esperaList) {
            System.out.printf("| %-4s | %-15s | %-15s | %-13s |\n", usuario.getId(), usuario.getNombre(), usuario.getContra(), usuario.getTipo());
        }
        System.out.println("-----------------------------------------------------------");

    }
    public void altaUsuario() {

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\nEsta es la lista actualizada de usuarios en espera.");

            tablaEspera();

            System.out.println("\nIngrese el id del usuario que quiera dar de alta");
            String input = reader.readLine();
            addUsuario(input);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void addUsuario(String id) {

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String nombre = "";
            String password = "";
            String tipo = "";
            String realID = "";

            for (espera usuario : esperaList) {

                if (usuario.getId().equalsIgnoreCase(id)) {
                    if (usuario.getTipo().equalsIgnoreCase("Bibliotecario")) {

                        if (!bibliotecarios.isEmpty()) {
                            id = bibliotecarios.get(bibliotecarios.size() - 1).getId();
                        }

                        System.out.println("ultimo id ingresado (" + id + ")\nIngrese un id para el nuevo usuario:");
                        realID = reader.readLine();

                        nombre = usuario.getNombre();
                        password = usuario.getContra();
                        tipo = usuario.getTipo();

                        bibliotecario neoB = new bibliotecario(realID, nombre, password, tipo);
                        bibliotecarios.add(neoB);

                        String path = "fpoo-practica-4-abstraccion-1-jigglypuff\\bd_usuarios.csv";

                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {

                            String line = realID + "," + nombre + "," + password + "," + tipo;
                            writer.write(line);
                            writer.newLine();

                            System.out.println("usuario autorizado.");

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else if (usuario.getTipo().equalsIgnoreCase("Estudiante")) {

                        if (!estudiantes.isEmpty()) {
                            id = estudiantes.get(estudiantes.size() - 1).getId();
                        }

                        System.out.println("ultimo id ingresado (" + id + ")\nIngrese un id para el nuevo usuario:");
                        realID = reader.readLine();

                        nombre = usuario.getNombre();
                        password = usuario.getContra();
                        tipo = usuario.getTipo();

                        estudiante neoE = new estudiante(realID, nombre, password, tipo);
                        estudiantes.add(neoE);

                        String path = "fpoo-practica-4-abstraccion-1-jigglypuff\\bd_usuarios.csv";

                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {

                            String line = realID + "," + nombre + "," + password + "," + tipo;
                            writer.write(line);
                            writer.newLine();

                            System.out.println("usuario autorizado.");

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // metodos buscar recursos
    public void buscarRecursoTitulo() {

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese el titulo del recurso a buscar:");
            String titulo = reader.readLine();


        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
