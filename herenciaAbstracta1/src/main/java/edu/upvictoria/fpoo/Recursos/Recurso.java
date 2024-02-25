package edu.upvictoria.fpoo.Recursos;

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

}
