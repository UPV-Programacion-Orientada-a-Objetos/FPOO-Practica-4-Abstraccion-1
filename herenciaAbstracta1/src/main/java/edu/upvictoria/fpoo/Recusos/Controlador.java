package edu.upvictoria.fpoo.Recusos;

import edu.upvictoria.fpoo.Usuarios.Estudiantes;
import edu.upvictoria.fpoo.Usuarios.Profesores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controlador extends IOException {
    public void menuRecursos() throws IOException {
        int opc=0;
        while(opc!=4){
            opc=menuRecur();
            switch(opc){
                case 1:
                    //agregar recurso
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
    public int menuRecur()throws IOException{
        int opc=0;
        BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("___-¿Que desea hacer?-___");
        System.out.println("1)Agregar Recursos\n2)Eliminar Recursos\n3)Modificar Recursos");
        String entrada=leer.readLine();
        opc=Integer.parseInt(entrada);
        return opc;
    }

    public void AgregarRecurso()throws IOException{
        BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        System.out.println("Ingrese Autor");
        String nombre=leer.readLine();
        System.out.println("Ingrese titulo");
        String apellido=leer.readLine();
        System.out.println("Tipo de Recurso\n1)Bibliotecario\n2)Estudiante\n3)Profesor");
        entrada=leer.readLine();
        int opc=Integer.parseInt(entrada);
        int ID=obtenerID("src/main/Resources/RECURSOS.csv");
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
}
