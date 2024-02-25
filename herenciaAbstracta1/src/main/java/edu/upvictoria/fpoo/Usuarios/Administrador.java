package edu.upvictoria.fpoo.Usuarios;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Administrador extends Usuario{
    public void tipo(){
        this.tipo="Administrador";
    }

    public void FuncionesAdmin()throws IOException{///controlador de funciones administrador/////
        int opc=0;
        while(opc!=4){
          opc=menu();
          switch(opc){
              case 1:
                  //agregar recurso-usuario
                  break;
              case 2:
                  //eliminar
                  break;
              case 3:
                  //modificar
                  break;
          }
        }
    }
    public int menu()throws IOException{
        int opc=0;
        BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
       System.out.println("___-¿Que desea hacer?-___");
       System.out.println("1)Agregar\n2)Eliminar\n3)Modificar");
       String entrada=leer.readLine();
       opc=Integer.parseInt(entrada);
       return opc;
    }
    public void AgregarUsuario()throws IOException{
        BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
        String entrada;
      System.out.println("Ingrese nombre de usuario");
      System.out.println("Ingrese apellido de usuario");
      System.out.println("Ingrese contrasela del usuario");
      System.out.println("Tipo de usuario\n1)Administrador\n2)Estudiante\n3)Profesor");
    }
    public int obtenerID(String archivo)throws IOException{
       int ID=0;
       try(BufferedReader leer=new BufferedReader(new FileReader("src/main/Resources/USD.csv"))){
           leer.readLine();
           String linea;
           while((linea=leer.readLine())!=null){
               String []datos=linea.split("\t");
              if(datos[0]!=null){
                  int id=Integer.parseInt(datos[0]);
                  ID=id+1;
              }else{
                  ID=1000;
              }
           }
       }catch (IOException e){
       }
       return ID;
    }
}
