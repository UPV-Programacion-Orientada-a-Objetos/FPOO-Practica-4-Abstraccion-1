package edu.upvictoria.fpoo;
import edu.upvictoria.fpoo.Usuarios.Administrador;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class App
{
    public static void main( String[] args )throws IOException
    {
        Menu mn=new Menu();
        int opc=0;
        System.out.println("---- BIENVENIDO ----");
        while(opc!=4){
            opc=mn.opciones();
            switch(opc){
                case 1:
                    mn.usuarios();
                    break;
                case 2:
                    //Recursos
                    mn.recursos();
                    break;
                case 3:
                    //prestamos
                    break;
                default:
                    break;
            }
        }
    }

}
