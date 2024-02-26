package edu.upvictoria.fpoo.Usuarios;


import edu.upvictoria.fpoo.Modificar;

import java.io.*;
import java.nio.Buffer;

public class Administrador extends Usuario{
    public void FuncionesAdmin()throws IOException{///controlador de funciones administrador/////
        int opc=0;
        while(opc!=4){
          opc=menu();
          switch(opc){
              case 1:
                  //agregar recurso-usuario
                  AgregarUsuario();
                  break;
              case 2:
                  //eliminar
                  eliminarUsuario();
                  break;
              case 3:
                  //modificar
                  modificar(); 
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
      String nombre=leer.readLine();
      System.out.println("Ingrese apellido de usuario");
      String apellido=leer.readLine();
      System.out.println("Ingrese contraseña del usuario");
      String contraseña=leer.readLine();
      System.out.println("Tipo de usuario\n1)Bibliotecario\n2)Estudiante\n3)Profesor");
      entrada=leer.readLine();
      int opc=Integer.parseInt(entrada);
      int ID=obtenerID("src/main/Resources/USD.csv");
      if(opc==1){
          String tipo_1="Administrador";
          crearUsuario(nombre,apellido,ID,tipo_1,contraseña);
          insertarUsuario();
      }
      else if(opc==2){
          Estudiantes es=new Estudiantes();
          String tipo="Estudiante";
          es.crearUsuario(nombre,apellido,ID,tipo,contraseña);
          es.insertarUsuario();
      }
      else if(opc==3){
          Profesores pr=new Profesores();
          String tipo="Profesor";
          pr.crearUsuario(nombre,apellido,ID,tipo,contraseña);
          pr.insertarUsuario();
      }
    }

    public int obtenerID(String archivo)throws IOException{
       int ID=0;
       try(BufferedReader leer=new BufferedReader(new FileReader("src/main/Resources/USD.csv"))){
           String linea;
           while((linea=leer.readLine())!=null){
               String []datos=linea.split("\t");
              if(datos[0]!=null){
                  int id=Integer.parseInt(datos[0]);
                  ID=id+1;
              }
           }
           leer.close();
       }catch (IOException e){
       }
       return ID;
    }
    public void eliminarUsuario()throws IOException{
        BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        System.out.println("ID del usuario a eliminar");
        entrada= leer.readLine();
        int id=Integer.parseInt(entrada);
        eliminar("src/main/Resources/USD.csv",id);
    }
    public void eliminar(String archivo,int ID)throws IOException{
        int opc=0;
        String []datos;
        try{
            BufferedReader br=new BufferedReader(new FileReader(archivo));
            File archivonvo=new File(archivo+ ".temp");
            PrintWriter pw = new PrintWriter(new FileWriter(archivonvo));
            String linea;
            while((linea=br.readLine())!=null){
                datos=linea.split("\t");
                String iid=datos[0];
                if(iid.equals("ID")){
                    pw.println(linea);
                }else{
                    int ID_enc=Integer.parseInt(iid);
                    if(ID!=ID_enc){
                        pw.println(linea);
                    }else{
                        System.out.println("Informacion a eliminar");
                        for(int i=0;i<datos.length;i++){
                            System.out.print(datos[i]+",");
                        }System.out.print("\b");

                    }
                }
            }

            br.close();
            pw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        File file=new File(archivo);
        File filetemp=new File(archivo+ ".temp");
        if(filetemp.exists()){
            if(file.exists()) file.delete();
            filetemp.renameTo(file);
        }
    }

    public void modificar()throws IOException{
        BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el ID del usuario a modificar");
        String entrada= leer.readLine();
        int id=Integer.parseInt(entrada);
        Modificar md=new Modificar();
        md.modificarUsuario(id);
    }
}
