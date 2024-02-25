package edu.upvictoria.fpoo.Recursos;

import java.io.*;

public class Libro extends Recurso{
    public Libro(){
        super.setTipo("Libro");
    }
    public void NuevoLibro(Recurso recurso) {
        System.out.println("Nuevo Libro!!");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Recursos.csv", true))) {
            BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));


            recurso.setTipo("Libro");

            System.out.println("Ingresa el ID del libro: ");
            recurso.setNum_id(bufer.readLine());

            System.out.println("Ingresa el titulo del libro: ");
            recurso.setTitulo(bufer.readLine());

            System.out.println("Ingresa el autor del libro: ");
            recurso.setAutor(bufer.readLine());

            writer.write(recurso.getNum_id() + "\t" + recurso.getTitulo() + "\t" + recurso.getTipo() + "\t" + recurso.getAutor() + "\t" + "disponible");
            writer.newLine();

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }
}
