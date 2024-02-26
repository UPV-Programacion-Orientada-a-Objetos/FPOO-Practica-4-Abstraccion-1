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
            opc=opciones();
            switch(opc){
                case 1:
                    //registrar usuarios
                    String tt= mn.inicio_Sesion();
                    if(tt!="No existe"){
                        if(tt.equals("Bibliotecario")) {
                            System.out.println("Usuario: Bibliotecario");
                            Administrador admin=new Administrador();
                            admin.FuncionesAdmin();
                        }else{
                            System.out.println("Acceso Denegado\nIntente nuevamente");
                        }
                    }else if(tt.equals("No existe")){
                        System.out.println("Ingrese usuario (Bibliotecario)");

                    }
                    break;
                case 2:
                    //Recursos
                    break;
                case 3:
                    //prestamos
                    break;
                default:
                    break;
            }
        }
    }
    public static int opciones()throws IOException{
        int opc=0;
        BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        System.out.println("¿Que desea hacer?\n1)Usuario\n2)Recursos\n3)Prestamos\n4)Salir");
        entrada=leer.readLine();
        opc=Integer.parseInt(entrada);
        return opc;
    }
}
