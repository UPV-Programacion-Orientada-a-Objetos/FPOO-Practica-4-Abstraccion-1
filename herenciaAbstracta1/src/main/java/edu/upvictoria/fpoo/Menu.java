package edu.upvictoria.fpoo;
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
           System.out.println("Existe");
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
}
