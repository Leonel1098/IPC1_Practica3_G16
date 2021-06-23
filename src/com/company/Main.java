package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Cursos[] curso;
    static int contadorCursos;
    public static Notas[] notas;
    static int contadorNotas;

    public static void main(String[] args) throws FileNotFoundException {
        LeerFolder();

        //CargarCursos();
        mostrarCursos();
       // CargarNotas();
       //notas();
       NotasPorCurso();
    }
    public static void notas (){
        System.out.println("notas");
        for (int i =0 ;i<contadorNotas;i++){
            System.out.println("Alumnos"+notas[i].getIdalumno()+": Curso "+ notas[i].getIdcurso()+" nota "+ notas[i].getNota());
        }
    }
        //Ruta que de la Carpeta a leer
    static String ruta = "C:\\Users\\Usuario\\Documents\\IPC1\\Vacas\\Practica3\\TextFiles";
    public static void LeerFolder(){
        try{
            DirectoryStream<Path> ds = Files.newDirectoryStream(Paths.get(ruta));
            for (Path r : ds){

                System.out.println(r.getFileName());

                if (r.getFileName().toString().equals("Cursos.csv")) {
                    CargarCursos();

                }if (r.getFileName().toString().equals("Notas.csv")) {
                    CargarNotas();
                }

            }
        }catch (Exception e){


        }

    }

    public static void llenarArray(String ruta) throws FileNotFoundException {


        // codigo para abrir archivos
        try{
            FileReader frC = new FileReader(ruta+"\\Cursos.csv");
            BufferedReader bfC = new BufferedReader(frC);

            curso = new Cursos[(int) (bfC.lines().count())];

        }catch (Exception e){

        }




    }

    public static void llenarArrayNotas(String ruta) throws FileNotFoundException {

        try {

            FileReader frC = new FileReader(ruta + "\\Notas.csv");

            BufferedReader bfC = new BufferedReader(frC);
            notas = new Notas[(int) (bfC.lines().count())];

        } catch (Exception e) {

        }


    }


    public static void CargarCursos() throws FileNotFoundException {
        llenarArray(ruta);

        // ruta en donde stael archivo
        // codigo para abrir archivos
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;


        try {
            // OBJETOS PARA ABRIR LOS ARCHIVOS
            archivo = new File(ruta+"\\Cursos.csv");

            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            ;

            // LEYENDO EL ARCHIVO
            String linea = br.readLine();

            int contLineas = 1;
            while ((linea = br.readLine()) != null) {

                // Aqui estamos leyendo fila por fila, entonces vamos a
                //almacenar esa informacion en nuestro arreglo de Alumnos

                // Separando los datos por una coma
                String[] Datos = linea.split(",");
                Datos[0] = Datos[0].trim();
                Datos[1] = Datos[1].trim();
                Datos[2] = Datos[2].trim();
                ;


                if (Datos[0].matches(".[/!#$%&/()=¿) ].*")) {

                    contLineas++;
                    continue;
                }
                if (Datos[1].matches(".[/!#$%&/()=¿)].*")) {

                    contLineas++;
                    continue;
                }
                if (Datos[2].matches(".[/!#$%&/()=¿)].*")) {

                    contLineas++;
                    continue;
                }


                try {
                    contLineas++;
                    int id = Integer.parseInt(Datos[0]);
                    int codigo = Integer.parseInt(Datos[1]);
                    String nombre = Datos[2];
                    boolean ids = false;
                    for (int i = 0; i < contadorCursos; i++) {
                        if (id == curso[i].getId()) {
                            ids = true;
                        }
                    }
                    if (ids) {

                        contLineas++;
                        continue;
                    }

                    boolean cod = false;
                    for (int i = 0; i < contadorCursos; i++) {
                        if (codigo == curso[i].getCodigo()) {
                            cod = true;
                        }
                    }
                    if (cod) {

                        contLineas++;
                        continue;
                    }

                    if (nombre.equals(" ")) {

                        contLineas++;
                        continue;
                    }
                    if (nombre.equals("")) {

                        contLineas++;
                        continue;
                    }


                    //Con nuestros datos, Alumno crear un objeto de tipo Alumno
                    Cursos nuevo = new Cursos(id, codigo, nombre);
                    //agregamos este objeto a nuestro arreglo
                    curso[contadorCursos] = nuevo;
                    contadorCursos++;
                } catch (Exception e) {
                    String error = e.getMessage();
                    String erro2 = e.getLocalizedMessage();

                    String DErr[] = error.split(":");
                    if (DErr[0].equals("For input string")) {

                    }
                }


            }
        } catch (Exception e) {


        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                System.out.println(e2);
                System.out.println("ERROR EN LA CARGA DEL ARCHIVO");
            }

        }

    }

    //Método Mostrar Cursos
    public static void mostrarCursos() {
        System.out.println("Mostrando Todos los Datos Dentro Del Objeto ");
        for (int i = 0; i < contadorCursos; i++) {
            System.out.println("ID : " + curso[i].getId() + " Nombre :" + curso[i].getNombre() + " Código :"
                    + curso[i].getCodigo());
        }
    }

    public static void CargarNotas() throws FileNotFoundException {
        llenarArrayNotas(ruta);
        // ruta en donde stael archivo

        // codigo para abrir archivos
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // OBJETOS PARA ABRIR LOS ARCHIVOS
            archivo = new File(ruta+"\\Notas.csv");

            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // LEYENDO EL ARCHIVO
            String linea = br.readLine();
            while ((linea = br.readLine()) != null) {
                int contLineas = 0;
                // Aqui estamos leyendo fila por fila, entonces vamos a
                //almacenar esa informacion en nuestro arreglo de Alumnos

                // Separando los datos por una coma
                String[] Datos = linea.split(",");
                Datos[0] = Datos[0].trim();
                Datos[1] = Datos[1].trim();
                Datos[2] = Datos[2].trim();


                if (Datos[0].matches(".[/!#$%&/()=¿) ].*")) {

                    contLineas++;
                    break;
                }
                if (Datos[1].matches(".[/!#$%&/()=¿)].*")) {

                    contLineas++;
                    break;
                }
                if (Datos[2].matches(".[/!#$%&/()=¿)].*")) {

                    contLineas++;
                    break;
                }

                // Segun la estructura del archivo, sabemos que como vienen los datos:
                // Recordemos que estos datos son string, entonces si es
                //necesario convertimos los datos
                try {
                    contLineas++;
                    int idalumno = Integer.parseInt(Datos[0]);
                    int idcurso = Integer.parseInt(Datos[1]);
                    double nota = Double.parseDouble(Datos[2]);

                    //Con nuestros datos, Alumno crear un objeto de tipo Alumno
                    if (nota > 100) {
                        continue;

                    }
                    boolean idRepetido = false;
                    for (int i = 0; i < contadorNotas; i++) {
                        if ((idalumno == notas[i].getIdalumno()) && (idcurso == notas[i].getIdcurso())) {
                                idRepetido=true;
                            }
                    }if (idRepetido){
                        continue;
                    }

                    Notas nuevo = new Notas(idalumno, idcurso, nota);
                    //agregamos este objeto a nuestro arreglo
                    notas[contadorNotas] = nuevo;
                    contadorNotas++;


                } catch (Exception e) {
                    String error = e.getMessage();
                    String erro2 = e.getLocalizedMessage();
                    String DErr[] = error.split(":");
                    if (DErr[0].equals("For input string")) {
                    }
                }


            }
        } catch (Exception e) {
            System.out.println("Ruta No Encontrada :(");
            System.out.println(e);
            System.out.println("ERROR EN LA CARGA DEL ARCHIVO");

        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                System.out.println(e2);
                System.out.println("ERROR EN LA CARGA DEL ARCHIVO");
            }

        }

    }

    public static String MostrarCurso(int idCurso) {

        for (int i = 0; i < contadorCursos; i++) {

            if (idCurso == curso[i].getId()) ;



            return curso[i].getNombre();
        }
        return "";
    }

    public static void MostrarNotasdelCurso(int idCurso,int idCursEnNotas) {
        for (int i =0 ; i<contadorNotas;i++){
            if (idCurso==idCursEnNotas){
                System.out.println("Nota " + notas[i].getNota());

            }

        }


    }

    public static void NotasPorCurso() {

        for (int i = 0; i < contadorCursos; i++) {

            System.out.println("Nombre Curso " + curso[i].getNombre());
            for (int j=0;j<contadorNotas;j++){

                if (curso[i].getId()==notas[j].getIdcurso()){
                    System.out.println("id Alumno  " + notas[j].getIdalumno());
                    System.out.println("Nota "+ notas[j].getNota());
                }
            }



    }
    }
}
