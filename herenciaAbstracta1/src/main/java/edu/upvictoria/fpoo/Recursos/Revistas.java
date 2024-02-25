package edu.upvictoria.fpoo.Recursos;

import java.io.*;

public class Revistas extends Recurso{
    //Revistas
    public Revistas(){
        super.setTipo("Revista");
    }
    public void NuevaRevista(Recurso recurso) {
        System.out.println("Nueva Revista!!");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Recursos.csv", true))) {
            BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));


            recurso.setTipo("Revista");

            System.out.println("Ingresa el ID de la Revista: ");
            recurso.setNum_id(bufer.readLine());

            System.out.println("Ingresa el titulo de la Revista: ");
            recurso.setTitulo(bufer.readLine());

            System.out.println("Ingresa el autor de la Revista: ");
            recurso.setAutor(bufer.readLine());

            writer.write(recurso.getNum_id() + "\t" + recurso.getTitulo() + "\t" + recurso.getTipo() + "\t" + recurso.getAutor() + "\t" + "disponible");
            writer.newLine();

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }
}
