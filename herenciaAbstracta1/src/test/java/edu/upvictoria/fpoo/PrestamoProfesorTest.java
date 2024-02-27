package edu.upvictoria.fpoo;
import java.time.LocalDate;
public class PrestamoProfesorTest {
    public static void main(String[] args) {
        testCrearPrestamo();
        testFechaVencimiento();
    }
    public static void testCrearPrestamo() {
        LocalDate fechaPrestamo = LocalDate.of(2024, 2, 23);
        PrestamoProfesor prestamo = new PrestamoProfesor(fechaPrestamo);

        System.out.println("Prueba Crear Prestamo:");
        assert prestamo.getFechaPrestamo().equals(fechaPrestamo) : "Error en la fecha de préstamo";
        System.out.println("Fecha de préstamo: " + prestamo.getFechaPrestamo());
    }
    public static void testFechaVencimiento() {
        LocalDate fechaVencimiento = LocalDate.of(2024, 3, 1);
        PrestamoProfesor prestamo = new PrestamoProfesor(fechaVencimiento);

        System.out.println("Prueba Fecha de Vencimiento:");
        LocalDate fechaEsperada = fechaVencimiento.plusDays(7); // Suponiendo una semana de plazo
        assert prestamo.getFechaVencimiento().equals(fechaEsperada) : "Error en la fecha de vencimiento";
        System.out.println("Fecha de vencimiento: " + prestamo.getFechaVencimiento());
    }
}
