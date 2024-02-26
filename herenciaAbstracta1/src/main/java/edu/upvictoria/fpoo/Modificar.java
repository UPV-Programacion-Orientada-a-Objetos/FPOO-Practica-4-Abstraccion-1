package edu.upvictoria.fpoo;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.nio.Buffer;

public class Modificar {
    public void modificarUsuario(int ID)throws IOException{
        BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        String []datos;
        try{
            BufferedReader br=new BufferedReader(new FileReader("src/main/Resources/USD.csv"));
            File archivonvo=new File("src/main/Resources/USD.csv"+ ".temp");
            PrintWriter pw = new PrintWriter(new FileWriter(archivonvo));
            String linea;
            while((linea=br.readLine())!=null){
                datos=linea.split("\t");
                int ID_enc=Integer.parseInt(datos[0]);
                if(ID==ID_enc){
                    System.out.println("Información de usuario:\nID: "+datos[0]+"\nNombre: "+datos[1]+"\nApellido: "+datos[2]+"\nContraseña: "+datos[3]+"\nTipo de usuaripo:"+datos[4]+"\n¿Que desea modificar?");
                    System.out.println("\n1)Nombre\n2)Apellido\n3)Contraseña\n4)Tipo de usuario");
                    entrada=leer.readLine();
                    int opc=Integer.parseInt(entrada);
                    switch(opc){
                        case 1:
                            System.out.println("Escriba el nuevo nombre:");
                            String nvnombre=leer.readLine();
                            datos[1]=nvnombre;
                            break;
                        case 2:
                            System.out.println("Escribe nueva modificación a apellido:");
                            String nvcontraseña=leer.readLine();
                            datos[2]=nvcontraseña;
                            break;
                        case 3:
                            System.out.println("Escribe la nueva contraseña: ");
                            String contraseña=leer.readLine();
                            datos[3]=contraseña;
                            break;
                        case 4:
                            int U;
                            System.out.println("ELiga el nuevo tipo de usuario: \n1)Bibliotecario\n2)Estudiante\n3)Profesor\n");
                            entrada=leer.readLine();
                            U=Integer.parseInt(entrada);
                            if(U==1){
                                datos[4]="Bibliotecario";
                            }else if(U==2){
                                datos[4]="Estudiante";
                            }else if(U==3){
                                datos[4]="Profesor";
                            }
                    }
                    pw.println(String.join("\t",datos));
                }else{
                    pw.println(linea);
                }
            }
            br.close();
            pw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        File file=new File("src/main/Resources/USD.csv");
        File filetemp=new File("src/main/Resources/USD.csv"+ ".temp");
        if(filetemp.exists()){
            if(file.exists()) file.delete();
            filetemp.renameTo(file);
        }
    }

    public void modificarRecursos(int ID)throws IOException{
        BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        String []datos;
        try{
            BufferedReader br=new BufferedReader(new FileReader("src/main/Resources/RECURSOS.csv"));
            File archivonvo=new File("src/main/Resources/RECURSOS.csv"+ ".temp");
            PrintWriter pw = new PrintWriter(new FileWriter(archivonvo));
            String linea;
            while((linea=br.readLine())!=null){
                datos=linea.split("\t");
                int ID_enc=Integer.parseInt(datos[0]);
                if(ID==ID_enc){
                    System.out.println("Información de usuario:\nID: "+datos[0]+"\nAutor: "+datos[1]+"\nTitulo: "+datos[2]+"\nTipo: "+datos[3]+"\n"+"¿Que desea modificar?");
                    System.out.println("\n1)Autor\n2)Titulo\n3)Tipo");
                    entrada=leer.readLine();
                    int opc=Integer.parseInt(entrada);
                    switch(opc){
                        case 1:
                            System.out.println("Escriba modificación autor:");
                            String nvnombre=leer.readLine();
                            datos[1]=nvnombre;
                            break;
                        case 2:
                            System.out.println("Escribe nueva modificación a titulo:");
                            String nvcontraseña=leer.readLine();
                            datos[2]=nvcontraseña;
                            break;
                        case 3:
                            int U;
                            System.out.println("ELiga el nuevo tipo de recurso: \n1)Revista\n2)Diario\n3)Libro\n");
                            entrada=leer.readLine();
                            U=Integer.parseInt(entrada);
                            if(U==1){
                                datos[4]="Revista";
                            }else if(U==2){
                                datos[4]="Diario";
                            }else if(U==3){
                                datos[4]="Libro";
                            }
                    }
                    pw.println(String.join("\t",datos));
                }else{
                    pw.println(linea);
                }
            }
            br.close();
            pw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        File file=new File("src/main/Resources/RECURSOS.csv");
        File filetemp=new File("src/main/Resources/RECURSOS.csv"+ ".temp");
        if(filetemp.exists()){
            if(file.exists()) file.delete();
            filetemp.renameTo(file);
        }
    }
}
