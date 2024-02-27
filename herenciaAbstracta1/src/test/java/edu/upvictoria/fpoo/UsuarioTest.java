package edu.upvictoria.fpoo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class UsuarioTest {

    @Test
    public void testCrearUsuario() {
        Usuario usuario = new MiClaseDeUsuario();

        usuario.crearUsuario("Juan", "Perez", 12345, "TipoUsuario", "contraseña123");

        assertEquals("Juan", usuario.getNombre());
        assertEquals("Perez", usuario.getApellidos());
        assertEquals(12345, usuario.getID());
        assertEquals("Estudiante", usuario.getTipo());
        assertEquals("contraseña123", usuario.getContraseña());
    }
    @Test
    public void testInsertarUsuario() {
    }
}

