package edu.upvictoria.fpoo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class RecursoTest {
    @Test
    public void testCrearRecurso() {
        Recurso recurso = new MiClaseDeRecurso();
        recurso.CrearRecurso("Título del recurso", "Autor del recurso", "Tipo del recurso", 12345);

        assertEquals("Título del recurso", recurso.getTitulo());
        assertEquals("Autor del recurso", recurso.getAutor());
        assertEquals("Tipo del recurso", recurso.getTipo());
        assertEquals(12345, recurso.getID());
    }
    @Test
    public void testInsertarRecurso() {
    }
}
