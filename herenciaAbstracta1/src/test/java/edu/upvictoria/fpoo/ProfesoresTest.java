package edu.upvictoria.fpoo;
public class ProfesoresTest {
    public static void main(String[] args) {
        testCrearProfesor();
    }
    public static void testCrearProfesor() {
        String nombre = "Juan";
        String apellido = "Garcia";
        int edad = 36;
        String materia = "Programacion";

        Profesores profesor = new Profesores(nombre, apellido, edad, materia);
        System.out.println("Prueba Crear Profesor:");
        assert profesor.getNombre().equals(nombre) : "Error en el nombre";
        assert profesor.getApellido().equals(apellido) : "Error en el apellido";
        assert profesor.getEdad() == edad : "Error en la edad";
        assert profesor.getMateria().equals(materia) : "Error en la materia";

        System.out.println("Nombre: " + profesor.getNombre());
        System.out.println("Apellido: " + profesor.getApellido());
        System.out.println("Edad: " + profesor.getEdad());
        System.out.println("Materia: " + profesor.getMateria());



        public class ProfesoresTest {

            @Test
            public void testSomething() {
            }

        }

    }
}
