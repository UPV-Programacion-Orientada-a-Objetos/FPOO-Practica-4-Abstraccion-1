package edu.upvictoria.fpoo.Recursos;

import edu.upvictoria.fpoo.Usuarios.Estudiante;

import java.io.*;
import java.util.Objects;

public abstract class Recurso {
    //título, autor o número de identificación,
    private String titulo;
    private String autor;
    private String num_id;
    private String tipo;

    private String estado;


    public Recurso() {
    }

    public Recurso(String titulo, String autor, String num_id, String tipo) {
        this.titulo = titulo;
        this.autor = autor;
        this.num_id = num_id;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNum_id() {
        return num_id;
    }

    public void setNum_id(String num_id) {
        this.num_id = num_id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * buscar recurso por título y tipo
     */
    public boolean BuscarRecursoTitulo(Recurso recurso) throws IOException{
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String nombreArchivo = "Recursos.csv";
        File archivo = new File(nombreArchivo);
        boolean encontrado = false;
        System.out.println("ingresa el titulo del " + getTipo() + " : ");
        recurso.setTitulo(bufer.readLine());

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split("\t");
                if (columnas.length >= 3 && Objects.equals(recurso.getTitulo(), columnas[1]) && Objects.equals(recurso.getTipo(), columnas[2])) {
                    encontrado = true;
                    recurso.setAutor(columnas[3]);
                    recurso.setNum_id(columnas[0]);
                    recurso.setEstado(columnas[4]);
                    System.out.println("ID: " + recurso.getNum_id() + ", Titulo: " + recurso.getTitulo() + ", Tipo: " + recurso.getTipo() + ", Autor: " + recurso.getAutor() + ", Estado: " + recurso.getEstado());
                    return encontrado;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al buscar el usuario en el archivo: " + e.getMessage());
            throw e;
        }

        if (!encontrado) {
            System.out.println(recurso.getTipo() + " no encontrado.");
        }
        return false;
    }
    /**
     * buscar recurso por autor y tipo
     */
    public boolean BuscarRecursoAutor(Recurso recurso) throws IOException{
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String nombreArchivo = "Recursos.csv";
        File archivo = new File(nombreArchivo);
        boolean encontrado = false;
        System.out.println("ingresa el Autor del " + getTipo() + " : ");
        recurso.setAutor(bufer.readLine());

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int cont=0;
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split("\t");
                if (columnas.length >= 3 && Objects.equals(recurso.getAutor(), columnas[3]) && Objects.equals(recurso.getTipo(), columnas[2])) {
                    encontrado = true;
                    recurso.setTitulo(columnas[1]);
                    recurso.setNum_id(columnas[0]);
                    recurso.setEstado(columnas[4]);
                    System.out.println("ID: " + recurso.getNum_id() + ", Titulo: " + recurso.getTitulo() + ", Tipo: " + recurso.getTipo() + ", Autor: " + recurso.getAutor() + ", Estado: " + recurso.getEstado());
                    cont++;
                    continue;
                }
            }
            if (cont>0){
                return encontrado;
            }

        } catch (IOException e) {
            System.err.println("Error al buscar el usuario en el archivo: " + e.getMessage());
            throw e;
        }

        if (!encontrado) {
            System.out.println(recurso.getTipo() + " no encontrado.");
        }
        return false;
    }
    /**
     * eliminar recurso por is
     */
    public boolean EliminarRecurso(Recurso recurso) throws IOException{
        File archivo = new File("Recursos.csv");
        File archivoTemporal = new File("Temp2.csv");

        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemporal))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split("\t");

                if (columnas.length >= 1 && columnas[0].equals(recurso.getNum_id()) && columnas[2].equals(recurso.getTipo())) {//aqui si tengo que especificar el tipo pq son dif categorias
                    encontrado = true;
                    continue;
                }
                bw.write(linea);
                bw.newLine();
            }
        }
        archivo.delete();
        archivoTemporal.renameTo(archivo);


        return false;
    }
    /**
     * modificar recursos por is
     */
    public void Modificar_Recurso(Recurso recurso)throws IOException{
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String nombreArchivo = "Recursos.csv";
        File archivo = new File(nombreArchivo);
        boolean encontrado = false;
        System.out.println("ingresa el ID del " + getTipo() + " : ");
        recurso.setNum_id(bufer.readLine());

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split("\t");
                if (columnas.length >= 3 && Objects.equals(recurso.getNum_id(), columnas[0]) && Objects.equals(recurso.getTipo(), columnas[2])) {
                    encontrado = true;
                    recurso.EliminarRecurso(recurso);
                    //moficar con el menu
                    System.out.println("Ingresa el nuevo tipo de recurso: ");
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
                            System.out.println("opcion no valida");
                        }


                }
            }
        } catch (IOException e) {
            System.err.println("Error al buscar el recurso en el archivo: " + e.getMessage());
            throw e;
        }

        if (!encontrado) {
            System.out.println(recurso.getTipo() + " no encontrado.");
        }
    }

}
