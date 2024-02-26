package edu.upvictoria.fpoo.Usuarios;

import java.io.*;

public class Maestro extends Usuario {

    public Maestro(){
        super.setTipo_us("Maestro");
    }

    public void NuevoMaestro(Usuario us) {

        System.out.println("Nuevo Maestro!!");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Usuarios.csv", true))) {
            BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));

                us.setTipo_us("Maestro");
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
