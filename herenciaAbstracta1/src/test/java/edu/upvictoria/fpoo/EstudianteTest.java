package edu.upvictoria.fpoo;
public class EstudianteTest {
    public static void main(String[] args) {
        testCrearEstudiante();
        testAgregarElementos();
    }
    public static void testCrearEstudiante() {
        String nombre = "Mitzary";
        String apellido = "Hernandez";
        int edad = 19;
        String matricula = "2230142";

        Estudiante estudiante = new Estudiante(nombre, apellido, edad, matricula);
        System.out.println("Prueba Crear Estudiante:");
        System.out.println("Nombre: " + estudiante.getNombre());
        System.out.println("Apellido: " + estudiante.getApellido());
        System.out.println("Edad: " + estudiante.getEdad());
        System.out.println("Matrícula: " + estudiante.getMatricula());
    }
    public static void testAgregarElementos() {
        Estudiante estudiante = new Estudiante("Mitzary", "Hernandez", 19, "2230142");
        estudiante.agregarLibro("Libro1");
        estudiante.agregarDiario("Diario1");
        estudiante.agregarRevista("Revista1");
        estudiante.agregarPeriodico("Periodico1");

        System.out.println("Prueba Agregar Elementos:");
        assert estudiante.getLibros().get(0).equals("Libro1") : "Error al agregar libro";
        assert estudiante.getDiarios().get(0).equals("Diario1") : "Error al agregar diario";
        assert estudiante.getRevistas().get(0).equals("Revista1") : "Error al agregar revista";
        assert estudiante.getPeriodicos().get(0).equals("Periodico1") : "Error al agregar periódico";

        System.out.println("Elementos agregados correctamente.");


        public class EstudiantesTest {

            @Test
            public void testTipo() {
                Estudiantes estudiante = new Estudiantes();

                estudiante.tipo();

                assertEquals("Estudiante", estudiante.getTipo());
            }

        }


    }
}
