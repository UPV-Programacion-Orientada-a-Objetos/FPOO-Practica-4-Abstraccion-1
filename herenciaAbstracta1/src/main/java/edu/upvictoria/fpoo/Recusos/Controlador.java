package edu.upvictoria.fpoo.Recusos;

import edu.upvictoria.fpoo.Usuarios.Administrador;
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
                    AgregarRecurso();
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
        String autor=leer.readLine();
        System.out.println("Ingrese titulo");
        String libro=leer.readLine();
        System.out.println("Tipo de Recurso\n1)Libro\n2)Diario\n3)Revista");
        entrada=leer.readLine();
        int opc=Integer.parseInt(entrada);
        Administrador admin=new Administrador();
        int ID=admin.obtenerID("src/main/Resources/RECURSOS.csv");
        if(opc==1){
            String tipo_1="Libro";
            Libro lb=new Libro();
            lb.CrearRecurso(libro,autor,tipo_1,ID);
            lb.insertarRecurso();
        }
        else if(opc==2){
            String tip="Diario";
            Diario dr=new Diario();
            dr.CrearRecurso(libro,autor,tip,ID);
            dr.insertarRecurso();
        }
        else if(opc==3){
            String tip="Revista";
            Revista rv=new Revista();
            rv.CrearRecurso(libro,autor,tip,ID);
            rv.insertarRecurso();
        }
    }
}
