package edu.upvictoria.fpoo.Usuarios;

import edu.upvictoria.fpoo.Prestamos;

import java.util.ArrayList;

public class Estudiantes extends Usuario {
    public ArrayList<Prestamos>listaPrestamos= new ArrayList<>(3);

    public void tipo(){
        this.tipo="Estudiante";
    }

}
