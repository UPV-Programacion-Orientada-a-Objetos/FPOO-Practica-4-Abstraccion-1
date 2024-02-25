package edu.upvictoria.fpoo.persistencia;

import java.io.*;
import java.util.Objects;

public class Usuario {
    private String id;
    private String nombre;
    private Object tipo_us;


    public Usuario() {
    }

    public Usuario(String id, String nombre, Object tipo_us) {
        this.id = id;
        this.nombre = nombre;
        this.tipo_us = tipo_us;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object getTipo_us() {
        return tipo_us;
    }

    public void setTipo_us(Object tipo_us) {
        this.tipo_us = tipo_us;
    }

    public Boolean buscarUsuario(Usuario usuario) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String nombreArchivo = "Usuarios.csv";
        File archivo = new File(nombreArchivo);
        boolean encontrado = false;
        System.out.println("ingresa el nombre del usuario: ");
        usuario.setNombre(bufer.readLine());
        System.out.println("ingresa el ID del usuario: ");
        usuario.setId(bufer.readLine());

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split("\t");
                if (columnas.length >= 3 && Objects.equals(usuario.getId(), columnas[0]) && Objects.equals(usuario.getTipo_us(), columnas[2]) && usuario.getNombre().equals(columnas[1])) {
                    encontrado = true;
                    System.out.println("ID: " + columnas[0] + ", Nombre: " + columnas[1] + ", Ocupación: " + columnas[2]);
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al buscar el usuario en el archivo: " + e.getMessage());
            throw e;
        }

        if (!encontrado) {
            System.out.println("Usuario no encontrado.");
        }
        return false;
    }
}
