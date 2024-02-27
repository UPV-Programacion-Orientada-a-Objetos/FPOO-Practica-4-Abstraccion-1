package edu.upvictoria.fpoo;
import edu.upvictoria.fpoo.Usuarios.Administrador;

import java.io.*;

public class Prestamos {
    //// ATRIBUTOS PRÉSTAMO ////
    public int id;
    public String Usuario;
    public String apellido;
    public String titulo;
    public String autor;
    public String fechaInic;
    public String fechaFin;
    public String estado;

    public void crearprestamo(int IDus,String us,String ap, String titulo,String autor,String feI,String feF,String estado){
        this.id=IDus;
        this.Usuario=us;
        this.apellido=ap;
        this.titulo=titulo;
        this.autor=autor;
        this.fechaInic=feI;
        this.fechaFin=feF;
        this.estado=estado;
    }
    ////////////////////////////////// MENUU //////////////////////////////77
    public void prestamos()throws IOException{
        Prestamos pr=new Prestamos();
        int opc=0;
        while(opc!=5){
            opc=menuprestamos();
            switch(opc){
                case 1:
                    //préstamos
                    RegistrarPrestamo();
                    break;
                case 2:

                    //devolucion
                    break;
                case 3:

                    //renovacion
                    break;
                case 4:

                    //listar
                    break;
                default:
                    break;
            }
        }

    }
    public int menuprestamos()throws IOException{
        BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        int opc=0;
        System.out.println("1)Préstamo de recursos\n2)Devolución de Recursos\n3)Renovacion de Préstamo\n4)Usuarios con Préstamos Vencidos\n5)Salir");
        entrada=leer.readLine();
        opc=Integer.parseInt(entrada);
        return opc;
    }

    ///////////////////////// Préstamoooooooos /////////////////////////
    public void RegistrarPrestamo()throws IOException{
        BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        int NumPres=1,cont=0;
        while(cont!=NumPres) {
            imprimirRecursos();
            System.out.println("Escriba el ID del libro que desea: ");
            entrada = leer.readLine();
            int IDL = 0;
            int IDU=0;
            if (entrada.matches("[0-9]+")) {
                IDL = Integer.parseInt(entrada);
            } else {
                System.out.println("Error");
            }

            System.out.println("Escriba su ID: ");
            entrada = leer.readLine();
            if (entrada.matches("[0-9]+")) {
                IDU = Integer.parseInt(entrada);
            } else {
                System.out.println("Error");
            }
            NumPres = RegistroPrestamo(IDU,IDL);
            cont++;
        }
    }
    public void imprimirRecursos(){
        String archivo="src/main/Resources/RECURSOS.csv";
        try(BufferedReader br=new BufferedReader( new FileReader(archivo))) {
            String linea;
            br.readLine();
            while((linea=br.readLine())!=null){
                String[]datos=linea.split("/t");
                for(int i=0;i< datos.length;i++){
                    System.out.print(datos[i]+"\t");
                }
                System.out.println(" ");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public int RegistroPrestamo(int IDU, int IDL){
        int NumPres=0;
        //información-usuario
        String[] est=encontrarInfo("src/main/Resources/USD.csv",IDU);
        int idii=Integer.parseInt(est[0]);
        String nom=est[1];
        String apell=est[2];
        //informacion-recurso
        String[] estRe=encontrarInfo("src/main/Resources/RECURSOS.csv",IDL);
        String titu=estRe[2];
        String aut=estRe[1];

        
        return NumPres;
    }

    public String[] encontrarInfo(String archivo,int ID){
        String []info=null;
        try(BufferedReader br=new BufferedReader(new FileReader(archivo))){
            br.readLine();
            String linea;
            while((linea=br.readLine())!=null){
                String[]datos=linea.split("\t");
                int pass=Integer.parseInt(datos[3]);
                int idi=Integer.parseInt(datos[0]);
                if(ID==idi){
                    info=datos;
                    return info;
                }else{
                    info=null;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return info;
    }


}
