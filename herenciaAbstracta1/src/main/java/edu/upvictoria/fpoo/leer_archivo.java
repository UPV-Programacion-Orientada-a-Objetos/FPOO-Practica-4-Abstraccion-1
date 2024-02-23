package edu.upvictoria.fpoo;

import edu.upvictoria.fpoo.estado.prestamo;
import edu.upvictoria.fpoo.recursos.diario;
import edu.upvictoria.fpoo.recursos.libro;
import edu.upvictoria.fpoo.recursos.revista;
import edu.upvictoria.fpoo.users.bibliotecario;
import edu.upvictoria.fpoo.users.espera;
import edu.upvictoria.fpoo.users.estudiante;
import edu.upvictoria.fpoo.users.profesor;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class leer_archivo {

    // listas para material
    private List<libro> libros;
    private List<revista> revistas;
    private List<diario> periodicos;

    // listas para usuarios
    private List<bibliotecario> bibliotecarios;
    private List<estudiante> estudiantes;
    private List<profesor> profesores;
    private List<espera> esperaList;

    // listas prestamos
    private List<prestamo> prestamos;

    protected InputStream isFile(String fileName) {
        try {
            String filePath = "C:\\Users\\amrdz\\Documents\\cuatri v\\fpoo\\unidad 1\\practica 4\\fpoo-practica-4-abstraccion-1-jigglypuff\\" + fileName;
            return new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    // leer csv para USUARIOS
    public InputStream getBD_usuarios() {
        return isFile("bd_usuarios.csv");
    }
    public InputStream getBD_espera() {
        return isFile("bd_listaEspera.csv");
    }


    // leer csv para MATERIAL
    public InputStream getBD_recursos() {
        return isFile("bd_recursos.csv");
    }

    // leer csv para PRESTAMOS
    public InputStream getBD_prestamos() {
        return isFile("bd_prestamos.csv");
    }

    // guardar usuarios
    public List<espera> guardarEspera() {
        esperaList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(getBD_espera(), StandardCharsets.UTF_8))) {
            String line;
            boolean header = true;

            while ((line = br.readLine()) != null) {
                if (header) {
                    header = false;
                    continue;
                }

                String[] campos = line.split(",");
                String id = campos[0].trim();
                String nombre = campos[1].trim();
                String contra = campos[2].trim();
                String tipo = campos[3].trim();

                espera esperante = new espera(id, nombre, contra, tipo);
                esperaList.add(esperante);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return esperaList;
    }
    public List<bibliotecario> guardarBibliotecarios() {
        bibliotecarios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(getBD_usuarios(), StandardCharsets.UTF_8))) {
            String line;
            boolean header = true;

            while ((line = br.readLine()) != null) {
                if (header) {
                    header = false;
                    continue;
                }

                String[] campos = line.split(",");
                String id = campos[0].trim();
                String nombre = campos[1].trim();
                String contra = campos[2].trim();
                String tipo = campos[3].trim();

                bibliotecario bib = new bibliotecario(id, nombre, contra, tipo);
                bibliotecarios.add(bib);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bibliotecarios;
    }
    public List<estudiante> guardarEstudiantes() {
        estudiantes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(getBD_usuarios(), StandardCharsets.UTF_8))) {
            String line;
            boolean header = true;

            while ((line = br.readLine()) != null) {
                if (header) {
                    header = false;
                    continue;
                }

                String[] campos = line.split(",");
                String id = campos[0].trim();
                String nombre = campos[1].trim();
                String contra = campos[2].trim();
                String tipo = campos[3].trim();

                estudiante est = new estudiante(id, nombre, contra, tipo);
                estudiantes.add(est);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return estudiantes;
    }
    public List<profesor> guardarProfesores() {
        profesores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(getBD_usuarios(), StandardCharsets.UTF_8))) {
            String line;
            boolean header = true;

            while ((line = br.readLine()) != null) {
                if (header) {
                    header = false;
                    continue;
                }

                String[] campos = line.split(",");
                String id = campos[0].trim();
                String nombre = campos[1].trim();
                String contra = campos[2].trim();
                String tipo = campos[3].trim();

                profesor prof = new profesor(id, nombre, contra, tipo);
                profesores.add(prof);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return profesores;
    }

    // guardar recursos
    public List<libro> guardarLibros() {
        libros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(getBD_recursos(), StandardCharsets.UTF_8))) {
            String line;
            boolean header = true;

            while ((line = br.readLine()) != null) {
                if (header) {
                    header = false;
                    continue;
                }

                String[] campos = line.split(",");
                String id = campos[0].trim();
                String titulo = campos[1].trim();
                String autor = campos[2].trim();
                String tipo = campos[3].trim();

                libro lib = new libro(id, titulo, autor, tipo);
                libros.add(lib);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return libros;
    }


}
