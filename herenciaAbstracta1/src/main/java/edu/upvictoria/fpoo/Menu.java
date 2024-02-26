package edu.upvictoria.fpoo;
import edu.upvictoria.fpoo.Recusos.Controlador;
import edu.upvictoria.fpoo.Recusos.Libro;
import edu.upvictoria.fpoo.Recusos.Recurso;
import edu.upvictoria.fpoo.Usuarios.Administrador;

import java.io.*;

public class Menu {
   public String inicio_Sesion()throws IOException{
       BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
       System.out.println("/// Iniciar sesion ///\nIngrese nombre se usuario");
       String nombre=leer.readLine();
       System.out.println("Ingrese contraseña");
       String entrada= leer.readLine();
       int contraseña=Integer.parseInt(entrada);
       String[] Exist=existenciaUsuario(nombre,contraseña);
       if(Exist!=null){
           //System.out.println("Existe");
           return Exist[4];
       }else{
           System.out.println("No existe Usuario");
           return "No existe";
       }
   }
   public String[] existenciaUsuario(String nombre,int contraseña){
       String []tipo=null;
       try(BufferedReader br=new BufferedReader(new FileReader("src/main/Resources/USD.csv"))){
           br.readLine();
           String linea;
           while((linea=br.readLine())!=null){
               String []datos=linea.split("\t");
               int pass=Integer.parseInt(datos[3]);
               if(datos[1].equals(nombre)&&pass==contraseña){
                   tipo=datos;
                   return tipo;
               }else{
                   tipo=null;
               }
           }
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
       return tipo;
   }

    public int opciones()throws IOException{
        int opc=0;
        BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        System.out.println("¿Que desea hacer?\n1)Usuario\n2)Recursos\n3)Prestamos\n4)Salir");
        entrada=leer.readLine();
        opc=Integer.parseInt(entrada);
        return opc;
    }
    public void usuarios()throws IOException{
        String tt= inicio_Sesion();
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
            Administrador ad=new Administrador();
            ad.AgregarUsuario();
        }

    }
    public void recursos()throws IOException{
       BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
       String entrada;
       int opc=0;
       System.out.println("1)Realizar busqueda\n2)Realizar modificaciones");
       entrada=leer.readLine();
       opc=Integer.parseInt(entrada);
       if(opc==2){
           String tt_1=inicio_Sesion();
           if(tt_1!="No existe"){
               if(tt_1.equals("Bibliotecario")) {
                   System.out.println("Usuario: Bibliotecario -- Recursos");
                    Controlador rr= new Controlador();
                    rr.menuRecursos();
               }else{
                   System.out.println("Acceso Denegado\nIntente nuevamente");
               }
           }else if(tt_1.equals("No existe")){
               System.out.println("Ingrese usuario (Bibliotecario)");
               Administrador ad=new Administrador();
               ad.AgregarUsuario();
           }
       }else if(opc==1){
             //busqueda de recursos/////////////////////////
       }else{
           System.out.println("\n¡¡Seleccion incorrecta!!\nIntente de nuevo");
       }
    }
    public void prestamos(){

    }
}
