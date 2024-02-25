package edu.upvictoria.fpoo.Recursos;

import java.io.*;

public class Diario extends Recurso{
    public Diario(){
        super.setTipo("Diario");
    }
    public void NuevoDiario(Recurso recurso) {
        System.out.println("Nuevo Diario!!");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Recursos.csv", true))) {
            BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));


            recurso.setTipo("Diario");

            System.out.println("Ingresa el ID del Diario: ");
            recurso.setNum_id(bufer.readLine());

            System.out.println("Ingresa el titulo del Diario: ");
            recurso.setTitulo(bufer.readLine());

            System.out.println("Ingresa el autor del Diario: ");
            recurso.setAutor(bufer.readLine());

            writer.write(recurso.getNum_id() + "\t" + recurso.getTitulo() + "\t" + recurso.getTipo() + "\t" + recurso.getAutor() + "\t" + "disponible");
            writer.newLine();

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }
}
