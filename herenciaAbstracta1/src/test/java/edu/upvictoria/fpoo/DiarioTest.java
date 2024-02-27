package edu.upvictoria.fpoo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
    public class DiarioTest {
        @Test
        public void testTipo() {
            Diario diario = new Diario();
            diario.tipo();
            assertEquals("Diario", diario.getTipo());
        }

    }
