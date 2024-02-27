package edu.upvictoria.fpoo;
import java.time.LocalDate;

public class PrestamoEstudiantesTest {

    public static void main(String[] args) {
        testCrearPrestamo();
    }

    public static void testCrearPrestamo() {
        LocalDate fechaPrestamo = LocalDate.of(2024, 2, 23);
        PrestamoEstudiantes prestamoEstudiantes = new PrestamoEstudiantes(fechaPrestamo);

        System.out.println("Prueba Crear Prestamo:");
        assert prestamoEstudiantes.getFechaPrestamo().equals(fechaPrestamo) : "Error en la fecha de préstamo";
        assert prestamoEstudiantes.getFechaVencimiento().equals(fechaPrestamo.plusDays(7)) : "Error en la fecha de vencimiento";

        System.out.println("Fecha de préstamo: " + prestamoEstudiantes.getFechaPrestamo());
        System.out.println("Fecha de vencimiento: " + prestamoEstudiantes.getFechaVencimiento());
    }
}
