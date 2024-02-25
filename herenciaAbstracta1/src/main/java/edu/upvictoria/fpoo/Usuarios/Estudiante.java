package edu.upvictoria.fpoo.Usuarios;

import java.io.*;

public class Estudiante extends Usuario {
    public Estudiante(){
        super.setTipo_us("Estudiante");
    }
    public void NuevoEstudiante(Usuario us) {
        System.out.println("Nuevo estudiante!!");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Usuarios.csv", true))) {
            BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));


                us.setTipo_us("Estudiante");

                System.out.println("Ingresa el nombre: ");
                us.setNombre(bufer.readLine());

                System.out.println("Ingresa un id: ");
                us.setId(bufer.readLine());

                writer.write(us.getId() + "\t" + us.getNombre() + "\t" + us.getTipo_us() + "\t" + "0");
                writer.newLine();

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }
}
