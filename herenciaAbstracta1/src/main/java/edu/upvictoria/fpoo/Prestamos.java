package edu.upvictoria.fpoo;
import edu.upvictoria.fpoo.Usuarios.Administrador;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Prestamos {
    public int id;
    public String Usuario;
    public String apellido;
    public String titulo;
    public String autor;
    public String fechaInic;
    public String fechaFin;
    public String estado;

    public void prestamo()throws IOException{
        Menu mn=new Menu();
        String tt= mn.inicio_Sesion();
        if(tt!="No existe"){
            if(tt.equals("Profesor")&&tt.equals("Estudiante")){
                System.out.println("Usuario: "+tt);
                Administrador admin=new Administrador();
                admin.FuncionesAdmin();
            }else{
                System.out.println("Acceso Denegado\nIntente nuevamente");
            }
        }else if(tt.equals("No existe")){
            System.out.println("Intente nuevamente");
        }

    }

}
