package edu.upvictoria.fpoo;
public class BibliotecarioTest {
    public static void main(String[] args) {
        testCrearBibliotecario();
    }
    public static void testCrearBibliotecario() {
        String nombre = "Israel";
        String apellido = "Guijarro";
        int edad = 19;
        boolean llevaLibros = true;
        boolean llevaDiarios = false;2222
        boolean llevaRevistas = false;
        boolean llevaPeriodicos = false;

        Bibliotecario bibliotecario = new Bibliotecario(nombre, apellido, edad, llevaLibros, llevaDiarios, llevaRevistas, llevaPeriodicos);

        System.out.println("Prueba Crear Bibliotecario:");
        assert bibliotecario.getNombre().equals(nombre) : "Error en el nombre";
        assert bibliotecario.getApellido().equals(apellido) : "Error en el apellido";
        assert bibliotecario.getEdad() == edad : "Error en la edad";
        assert bibliotecario.llevaLibros() == llevaLibros : "Error en llevaLibros";
        assert bibliotecario.llevaDiarios() == llevaDiarios : "Error en llevaDiarios";
        assert bibliotecario.llevaRevistas() == llevaRevistas : "Error en llevaRevistas";
        assert bibliotecario.llevaPeriodicos() == llevaPeriodicos : "Error en llevaPeriodicos";

        System.out.println("Nombre: " + bibliotecario.getNombre());
        System.out.println("Apellido: " + bibliotecario.getApellido());
        System.out.println("Edad: " + bibliotecario.getEdad());
        System.out.println("Lleva libros: " + bibliotecario.llevaLibros());
        System.out.println("Lleva diarios: " + bibliotecario.llevaDiarios());
        System.out.println("Lleva revistas: " + bibliotecario.llevaRevistas());
        System.out.println("Lleva periódicos: " + bibliotecario.llevaPeriodicos());

        System.out.println("    OTROOOOOOOOOO       ");
        public void testTipo() {
            // Crear una instancia de Bibliotecario
            Bibliotecario bibliotecario = new Bibliotecario();

            // Llamar al método tipo() para establecer el tipo del bibliotecario
            bibliotecario.tipo();

            // Verificar que el tipo del bibliotecario sea "Bibliotecario"
            assertEquals("Bibliotecario", bibliotecario.getTipo());
        }
    }
}
