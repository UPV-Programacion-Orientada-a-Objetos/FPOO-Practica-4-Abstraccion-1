package edu.upvictoria.fpoo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class AppTest {

    @Test
    public void testMain() {
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        try {
            App.main(null); /
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
