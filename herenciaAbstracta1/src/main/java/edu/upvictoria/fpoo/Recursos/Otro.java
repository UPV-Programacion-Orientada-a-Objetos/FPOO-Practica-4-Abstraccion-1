package edu.upvictoria.fpoo.Recursos;

import java.io.*;

public class Otro extends Recurso{
    //otro
    public Otro(){
        super.setTipo("Otro");
    }
    public void NuevoRecurso(Recurso recurso) {
        System.out.println("Nuevo recurso!!");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Recursos.csv", true))) {
            BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("ingresa el tipo de material");
            recurso.setTipo(bufer.readLine());

            System.out.println("Ingresa el ID del recurso: ");
            recurso.setNum_id(bufer.readLine());

            System.out.println("Ingresa el titulo del recurso: ");
            recurso.setTitulo(bufer.readLine());

            System.out.println("Ingresa el autor del recurso: ");
            recurso.setAutor(bufer.readLine());

            writer.write(recurso.getNum_id() + "\t" + recurso.getTitulo() + "\t" + recurso.getTipo() + "\t" + recurso.getAutor() + "\t" + "disponible");
            writer.newLine();

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }
}
