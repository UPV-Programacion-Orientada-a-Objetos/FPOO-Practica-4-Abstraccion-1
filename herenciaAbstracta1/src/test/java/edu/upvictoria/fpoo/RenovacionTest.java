package edu.upvictoria.fpoo;
public class RenovacionTest {
    public static void main(String[] args) {
        boolean renovar = true;
        testRenovarPrestamo(renovar);
    }
    public static void testRenovarPrestamo(boolean renovar) {
        Renovacion renovacion = new Renovacion();

        if (renovar) {
            boolean renovado = renovacion.renovarPrestamo();

            if (renovado) {
                System.out.println("El préstamo ha sido renovado exitosamente.");
                assert renovado == true : "Error: el préstamo debería haber sido renovado exitosamente.";
            } else {
                System.out.println("No se pudo renovar el préstamo.");
                assert renovado == false : "Error: el préstamo no debería haber sido renovado.";
            }
        } else {
            System.out.println("El usuario decidió no renovar el préstamo.");
            assert renovar == false : "Error: el préstamo no debería ser renovado.";
        }
    }
}
