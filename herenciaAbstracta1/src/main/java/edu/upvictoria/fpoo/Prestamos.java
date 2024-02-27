package edu.upvictoria.fpoo;
import edu.upvictoria.fpoo.Usuarios.Administrador;

import java.io.*;
import java.time.LocalDate;

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
                    devolucion();
                    //devolucion
                    break;
                case 3:
                    Renovacion();
                    //renovacion
                    break;
                case 4:
                     if(verificacionBibliotecario()){
                         System.out.println("\nUsuarios con préstamos vencidos");
                        mostrarvencidos();
                        System.out.println("\n");
                     }else{
                         System.out.println("No tiene acceso");
                     }
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
        int cont=0;
        int acm=1;
        String NumPres;
        while((cont!=acm)) {
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
            if(NumPres.equals("Estudiante")){
                acm=3;
            }else if(NumPres.equals("Profesor")){
                acm=5;
            }
            cont++;
            System.out.println("Prestamo realizado\n\n"+"Desea sali?\nS)SI\nN)NO");
            entrada=leer.readLine();
            if(entrada.equals("S")){break;}
        }
        if(cont==acm){
            System.out.println("Ya no puede realizar préstamos por el momento\nLimite excedido");
        }
    }
    public void imprimirRecursos(){
        String archivo="src/main/Resources/RECURSOS.csv";
        try(BufferedReader br=new BufferedReader( new FileReader(archivo))) {
            String linea;
            br.readLine();
            while((linea=br.readLine())!=null){
                String[]datos=linea.split("/t");
                System.out.println("ID"+"\t"+"Autor"+"\t"+"Titulo"+"Tipo");
                for(int i=0;i< datos.length;i++){
                    System.out.print(datos[i]+"\t");
                }
                System.out.println(" ");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public String RegistroPrestamo(int IDU, int IDL){
        String NumPres=null;
        //información-usuario
        String[] est=encontrarInfo("src/main/Resources/USD.csv",IDU);
        int idii=Integer.parseInt(est[0]);
        String nom=est[1];
        String apell=est[2];
        NumPres=est[4];
        //informacion-recurso
        String[] estRe=encontrarInfo("src/main/Resources/RECURSOS.csv",IDL);
        String titu=estRe[2];
        String aut=estRe[1];
        LocalDate fechaactual=LocalDate.now();
        LocalDate fecha7dias=fechaactual.plusDays(7);
        String feI=fechaactual.toString();
        String feF=fecha7dias.toString();
        String Estado=null;
        if(feI.equals(feF)){
            Estado="Vencido";
        }else if(fechaactual.isAfter(fecha7dias)){
            Estado="Vencido";
        }else{
            Estado="Activo";
        }
        crearprestamo(idii,nom,apell,titu,aut,feI,feF,Estado);
        insertarPrestamo();
        return NumPres;
    }
    public String[] encontrarInfo(String archivo,int ID){
        String []info=null;
        try(BufferedReader br=new BufferedReader(new FileReader(archivo))){
            br.readLine();
            String linea;
            while((linea=br.readLine())!=null){
                String[]datos=linea.split("\t");
                //int pass=Integer.parseInt(datos[3]);
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
    ////Escribir prestamo/////
    public void insertarPrestamo(){
        String archivo="src/main/Resources/PRESTAMOS.csv";
        try(BufferedWriter wr=new BufferedWriter(new FileWriter(archivo, true))){
            wr.write(id+"\t"+Usuario+"\t"+apellido+"\t"+titulo+"\t"+autor+"\t"+fechaInic+"\t"+fechaFin+"\t"+estado);
            wr.newLine();
        }catch(IOException e){
        }
    }
////////////////////DEVOLUCIÓN DE PRESTAMOS//////////////////////////////////////
    public void devolucion()throws IOException{
        BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese su ID");
        String entrada=leer.readLine();
        int id=Integer.parseInt(entrada);
        String []infor=encontrarInfo("src/main/Resources/PRESTAMOS.csv",id);
        if(infor!=null){
          encontrarInfo22("src/main/Resources/PRESTAMOS.csv",id);
          System.out.println("Ingrese titulo del recurso a devolver");
          String titulo=leer.readLine();
          DevolucionModificacion(titulo);
        }else{
            System.out.println("No tiene préstamo de recursos");
        }
    }
    public void encontrarInfo22(String archivo,int ID){
        String []info=null;
        try(BufferedReader br=new BufferedReader(new FileReader(archivo))){
            br.readLine();
            String linea;
            System.out.println("ID"+"\t"+"Usuario"+"\t"+"Apellido"+"\t"+"Titulo"+"\t"+"Autor"+"\t"+"FechaInicio"+"\t"+"FechaFinal"+"\t"+"Estado");
            while((linea=br.readLine())!=null){
                String[]datos=linea.split("\t");
                int idi=Integer.parseInt(datos[0]);
                if(ID==idi){
                    for(int i=0;i<datos.length;i++){
                        System.out.print(datos[i]+"\t");
                    }
                    System.out.println(" ");
                    info=datos;
                }else{
                    info=null;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //return info;
    }
    public void DevolucionModificacion(String titulo){
            BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
            String entrada;
            String []datos;
            try{
                BufferedReader br=new BufferedReader(new FileReader("src/main/Resources/PRESTAMOS.csv"));
                File archivonvo=new File("src/main/Resources/PRESTAMOS.csv"+ ".temp");
                PrintWriter pw = new PrintWriter(new FileWriter(archivonvo));
                String linea;
                while((linea=br.readLine())!=null){
                    datos=linea.split("\t");
                    if(titulo.equals(datos[3])){
                        datos[7]="Devuelto";
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
            File file=new File("src/main/Resources/PRESTAMOS.csv");
            File filetemp=new File("src/main/Resources/PRESTAMOS.csv"+ ".temp");
            if(filetemp.exists()){
                if(file.exists()) file.delete();
                filetemp.renameTo(file);
            }
    }
    ////////////////////////// RENOVAR ///////////////////////////////////
    public void Renovacion()throws IOException{
        BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese su ID");
        String entrada=leer.readLine();
        int id=Integer.parseInt(entrada);
        String []infor=encontrarInfo("src/main/Resources/PRESTAMOS.csv",id);
        if(infor!=null){
            encontrarInfo22("src/main/Resources/PRESTAMOS.csv",id);
            System.out.println("Ingrese titulo del recurso a renovar");
            String titulo=leer.readLine();
            RenovarModificacion(titulo);
        }else{
            System.out.println("No tiene préstamo de recursos");
        }
    }
    public void RenovarModificacion(String titulo){
        BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        String []datos;
        try{
            BufferedReader br=new BufferedReader(new FileReader("src/main/Resources/PRESTAMOS.csv"));
            File archivonvo=new File("src/main/Resources/PRESTAMOS.csv"+ ".temp");
            PrintWriter pw = new PrintWriter(new FileWriter(archivonvo));
            String linea;
            while((linea=br.readLine())!=null){
                datos=linea.split("\t");
                if(titulo.equals(datos[3])){
                    LocalDate fechaactual=LocalDate.now();
                    LocalDate fecha7dias=fechaactual.plusDays(7);
                    datos[5]=fechaactual.toString();
                    datos[6]=fecha7dias.toString();
                    datos[7]="Activo";
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
        File file=new File("src/main/Resources/PRESTAMOS.csv");
        File filetemp=new File("src/main/Resources/PRESTAMOS.csv"+ ".temp");
        if(filetemp.exists()){
            if(file.exists()) file.delete();
            filetemp.renameTo(file);
        }
    }
/////////////////////////////////////LISTA DE VENCIDOS/////////////////////////////////////////////////////
    public boolean verificacionBibliotecario()throws IOException{
        System.out.println("Solo el usuario Bibliotecario puede acceder\nIngrese su ID");
        BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
        String entrada=leer.readLine();
        int ididi=Integer.parseInt(entrada);
        String[]datoss=encontrarInfo("src/main/Resources/USD.csv",ididi);
        if(datoss[4].equals("Bibliotecario")){
            return true;
        }else{
            return false;
        }
    }

    public void mostrarvencidos(){
        try(BufferedReader br=new BufferedReader(new FileReader("src/main/Resources/PRESTAMOS.csv"))){
            br.readLine();
            String linea;
            System.out.println("ID"+"\t"+"Usuario"+"\t"+"Apellido"+"\t"+"Tipo");
            while((linea=br.readLine())!=null){
                String []datos=linea.split("\t");
                if(datos[7].equals("Vencido")){
                    int opc=Integer.parseInt(datos[0]);
                    String []infor=encontrarInfo("src/main/Resources/USD.csv",opc);
                    for(int i=0;i< infor.length;i++){
                          if(i!=3){
                              System.out.print(infor[i]+"\t");
                          }
                    }
                    System.out.println("");
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
