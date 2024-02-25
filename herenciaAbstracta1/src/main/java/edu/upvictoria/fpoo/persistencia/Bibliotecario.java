package edu.upvictoria.fpoo.persistencia;

import java.io.*;

public class Bibliotecario extends Usuario{

    public Bibliotecario(){
        super.setTipo_us("Bibliotecario");
    }
    public void NuevoBibliotecario(Usuario us) {
        System.out.println("Nuevo bibliotecario!!");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Usuarios.csv", true))) {
            BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));

                us.setTipo_us("Bibliotecario");

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
