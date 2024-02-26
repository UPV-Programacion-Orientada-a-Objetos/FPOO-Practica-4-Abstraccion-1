package edu.upvictoria.fpoo.Logica;

import edu.upvictoria.fpoo.Recursos.*;
import edu.upvictoria.fpoo.Usuarios.Usuario;

import java.io.*;
import java.util.Objects;

public class Prestamos {
    public Prestamos() {
    }

    public void Guardar_info(Recurso recurso) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));

        String nombreArchivo = "Recursos.csv";
        File archivo = new File(nombreArchivo);
        boolean encontrado = false;
        System.out.println("Ingresa el título del " + recurso.getTipo() + ": ");
        recurso.setTitulo(bufer.readLine());

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            StringBuilder fileContent = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split("\t");
                if (columnas.length >= 3 && Objects.equals(recurso.getTitulo(), columnas[1]) && Objects.equals(recurso.getTipo(), columnas[2])) {
                    encontrado = true;
                    recurso.setAutor(columnas[3]);
                    recurso.setNum_id(columnas[0]);

                    System.out.println("Agregando a tus prestaciones!!");
                }
            }
        } catch (IOException e) {
            System.err.println("Error al buscar el usuario en el archivo: " + e.getMessage());
            throw e;
        }
    }

    public void prestar(Recurso recurso, Usuario us) throws IOException {
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingresa el tipo de recurso que deseas pedir prestado: ");
        System.out.println("1)Libro");
        System.out.println("2)Diario");
        System.out.println("3)Revista");
        System.out.println("4)Otro");
        int opc = Integer.parseInt(bufer.readLine());
        if (opc == 1) {
            recurso.setTipo("Libro");
        } else if (opc == 2) {
            recurso.setTipo("Diario");
        } else if (opc == 3) {
            recurso.setTipo("Revista");
        } else {
            recurso.setTipo("Otro");
        }

        Guardar_info(recurso);
        recurso.EliminarRecurso(recurso);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Recursos.csv", true))) {
            System.out.println("Ingresa el DIA en número de prestamo: ");
            String dia = bufer.readLine();
            System.out.println("Ingresa el mes y año (mm/aa) de préstamo: ");
            String mes_anio = bufer.readLine();
            String fecha_inicio = (dia + "/" + mes_anio);
            int dia_fin = Integer.parseInt(dia) + 5;
            String fecha_fin = (dia_fin + "/" + mes_anio);

            writer.write(recurso.getNum_id() + "\t" + recurso.getTitulo() + "\t" + recurso.getTipo() + "\t" + recurso.getAutor() + "\t" + "No disponible" + "\t" + fecha_inicio + "\t" + fecha_fin);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Prestamos.csv", true))) {
            writer.write(recurso.getTitulo() + "\t" + recurso.getTipo() + "\t" + us.getId());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }
}
