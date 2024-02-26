package edu.upvictoria.fpoo.Usuarios;

import java.io.*;

public class Bibliotecario extends Usuario {

    public Bibliotecario(){
        super.setTipo_us("Bibliotecario");
    }
    public void NuevoBibliotecario(Usuario us) {
        System.out.println("Nuevo bibliotecario!!");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Usuarios.csv", true))) {
            BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));

                us.setTipo_us("Bibliotecario");
            boolean encontrado;
                System.out.println("Ingresa el nombre: ");
                us.setNombre(bufer.readLine());

            do {
                System.out.println("ingresa el ID del "+ us.getTipo_us());
                us.setId(bufer.readLine());
                 encontrado=us.buscarUsuarioID(us);
            }while (encontrado==true);

                writer.write(us.getId() + "\t" + us.getNombre() + "\t" + us.getTipo_us() + "\t" + "false");
                writer.newLine();

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }
}
