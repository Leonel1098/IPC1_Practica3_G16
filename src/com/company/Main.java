package com.company;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Cursos[] curso;
    static int contadorCursos;
    public static Asignación[] notas;
    static int contadorNotas;
    public static Alumno[] alumnos;
    static int contadorAlumnos;


    public static void main(String[] args) throws FileNotFoundException {
        Carga nueva = new Carga();
        //LeerFolder();
        // mostrarAlumno();
        //CargarCursos();
        //mostrarCursos();
        // CargarNotas();
        //notas();
        //NotasPorCurso();
    }

    public static void Asignaciones() {
        System.out.println("notas");
        for (int i = 0; i < contadorNotas; i++) {
            System.out.println("Alumnos" + notas[i].getIdalumno() + ": Curso " + notas[i].getIdcurso() + " nota " + notas[i].getNota());
        }
    }
    //Ruta que de la Carpeta a leer
    //static String ruta = "C:\\Users\\Garcia\\IdeaProjects\\IPC1_Practica3_G16\\Archivos Practica3";

    public static void LeerFolder(String ruta) throws IOException {

            DirectoryStream<Path> ds = Files.newDirectoryStream(Paths.get(ruta));
            for (Path r : ds) {

                System.out.println(r.getFileName());

                //Condicionales para leer los Archivos
                if (r.getFileName().toString().equals("Cursos.csv")) {
                    CargarCursos(ruta);

                    if (r.getFileName().toString().equals("alumnos.csv")) {
                        //CargarAlumnos();
                    }

                    if (r.getFileName().toString().equals("cursos.csv")) {
                        //CargarCursos();

                    }
                    if (r.getFileName().toString().equals("asignaciones.csv")) {
                        //CargarAsignaciones();
                    }

                }
            }

        }



    public static void llenarArrayCursos(String ruta) throws FileNotFoundException {


        // codigo para abrir archivos
        try {
            FileReader frC = new FileReader(ruta + "/Cursos.csv");
            BufferedReader bfC = new BufferedReader(frC);

            curso = new Cursos[(int) (bfC.lines().count())];

        } catch (Exception e) {

        }


    }

    public static void llenarArrayAsignacion(String ruta) throws FileNotFoundException {

        try {

            FileReader frC = new FileReader(ruta + "/Asignaciones.csv");

            BufferedReader bfC = new BufferedReader(frC);
            notas = new Asignación[(int) (bfC.lines().count())];

        } catch (Exception e) {

        }


    }

    public static void llenarArrayAlumnos(String ruta) throws FileNotFoundException {

        try {

            FileReader frC = new FileReader(ruta + "/Alumnos.csv");

            BufferedReader bfC = new BufferedReader(frC);
            alumnos = new Alumno[(int) (bfC.lines().count())];

        } catch (Exception e) {

        }


    }

    public static void CargarCursos(String ruta) throws FileNotFoundException {
        llenarArrayCursos(ruta);

        // ruta en donde stael archivo
        // codigo para abrir archivos
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;


        try {
            // OBJETOS PARA ABRIR LOS ARCHIVOS
            archivo = new File(ruta + "/Cursos.csv");

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

    public static void CargarAsignaciones(String ruta) throws FileNotFoundException {
        llenarArrayAsignacion(ruta);
        // ruta en donde stael archivo

        // codigo para abrir archivos
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // OBJETOS PARA ABRIR LOS ARCHIVOS
            archivo = new File(ruta + "/asignaciones.csv");

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
                            idRepetido = true;
                        }
                    }
                    if (idRepetido) {
                        continue;
                    }

                    Asignación nuevo = new Asignación(idalumno, idcurso, nota);
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

    public static void MostrarNotasdelCurso(int idCurso, int idCursEnNotas) {
        for (int i = 0; i < contadorNotas; i++) {
            if (idCurso == idCursEnNotas) {
                System.out.println("Nota " + notas[i].getNota());

            }

        }


    }

    public static void NotasPorCurso() {

        for (int i = 0; i < contadorCursos; i++) {

            System.out.println("Nombre Curso " + curso[i].getNombre());
            for (int j = 0; j < contadorNotas; j++) {

                if (curso[i].getId() == notas[j].getIdcurso()) {
                    System.out.println("id Alumno  " + notas[j].getIdalumno());
                    System.out.println("Nota " + notas[j].getNota());
                }
            }


        }
    }

    public static void CargarAlumnos(String ruta) throws FileNotFoundException {
        llenarArrayAlumnos(ruta);

        // ruta en donde stael archivo
        // codigo para abrir archivos
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;


        try {
            // OBJETOS PARA ABRIR LOS ARCHIVOS
            archivo = new File(ruta + "/Alumnos.csv");

            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

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
                Datos[3] = Datos[3].trim();
                Datos[4] = Datos[4].trim();


                if (Datos[0].matches(".[/!#$%&/()=¿) ].*")) {

                    contLineas++;
                    continue;
                }
                if (Datos[1].matches(".[/!#$%&/()=¿)].*")) {

                    contLineas++;
                    continue;
                }
                if (Datos[2].matches(".[/123456789!#$%&/()=¿)].*")) {

                    contLineas++;
                    continue;
                }
                if (Datos[3].matches(".[!#$%&()=¿)].*")) {

                    contLineas++;
                    continue;
                }
                if (Datos[4].matches(".[/!#$%&/()=¿)].*")) {
                    contLineas++;
                    continue;
                }


                try {
                    contLineas++;
                    int id = Integer.parseInt(Datos[0]);
                    int carnet = Integer.parseInt(Datos[1]);
                    String nombre = Datos[2];
                    String fechanacimiento = Datos[3];
                    String Genero = Datos[4];

                    boolean idRepetido = false;
                    for (int i = 0; i < contadorAlumnos; i++) {
                        if (id == alumnos[i].getId()) {
                            idRepetido = true;
                        }
                    }
                    if (idRepetido) {

                        contLineas++;
                        continue;
                    }

                    boolean carnetRepetido = false;
                    for (int i = 0; i < contadorAlumnos; i++) {
                        if (carnet == alumnos[i].getCarnet()) {
                            carnetRepetido = true;
                        }
                    }
                    if (carnetRepetido) {

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

                    if (!Genero.equals("M")) {
                        if (!Genero.equals("F")) {
                            contLineas++;
                            continue;
                        }
                    }
                    if (Genero.equals(" ")) {
                        contLineas++;
                        continue;
                    }
                    if (Genero.equals("")) {
                        contLineas++;
                        continue;
                    }

                    //Con nuestros datos, Alumno crear un objeto de tipo Alumno
                    Alumno nuevo = new Alumno(id, carnet, nombre, fechanacimiento, Genero);
                    //agregamos este objeto a nuestro arreglo
                    alumnos[contadorAlumnos] = nuevo;
                    contadorAlumnos++;
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

    public static void mostrarAlumno() {
        System.out.println("Mostrando Todos los Datos Dentro Del Objeto ");
        for (int i = 0; i < contadorAlumnos; i++) {
            System.out.println("ID : " + alumnos[i].getId() + " Carnet :" + alumnos[i].getCarnet() + " Nombre :"
                    + alumnos[i].getNombre() + " Fecha de Nacimiento :" + alumnos[i].getFechanacimiento() + " Genéro :" + alumnos[i].getGenero());
        }


    }
    public static void MostrarAlumnosDeUnCurso(){
        System.out.println("Escrba el nombre del idDelCurso");
        int idCurso=sc.nextInt();
        for (int i=0; i<contadorCursos;i++){
            if (idCurso==curso[i].getId()){
                System.out.println(curso[i].getNombre());
            }
        }
        for (int i=0;i<contadorNotas;i++){
            if (idCurso==notas[i].getIdcurso()){
                System.out.println("Nombre :"+BuscarAlumnoPorId(notas[i].getIdalumno())+" nota  :"+
                        notas[i].getNota());

            }
        }
    }
    public static String BuscarAlumnoPorId(int idAlumno){
        for (int i=0;i<contadorAlumnos;i++){
            if (idAlumno==alumnos[i].getId()){
                return alumnos[i].getNombre();
            }
        }
        return "No Existe";
    }
    public static  void GraficaSexo(){
        System.out.println("Escrba el nombre del idDelCurso");
        int idCurso=sc.nextInt();
        for (int i=0; i<contadorCursos;i++){
            if (idCurso==curso[i].getId()){
                System.out.println(curso[i].getNombre());
            }
        }
        for (int i=0;i<contadorAlumnos;i++){
            if (idCurso==notas[i].getIdcurso()){
                System.out.println("Nombre :"+BuscarAlumnoPorId(notas[i].getIdalumno())+" nota  :"+
                        notas[i].getNota());
                System.out.println("Sexo " +BuscaSexoDelAlumno(notas[i].getIdalumno()));
            }
        }

    }
    public static String BuscaSexoDelAlumno(int idAlumno){

            for (int i=0;i<contadorAlumnos;i++){
                if (idAlumno==alumnos[i].getId()){
                    return alumnos[i].getGenero();
                }
            }
            return "%";

    }
    /*
    a.setValue("Femenino  ", f);

        // Creando el Grafico
        chart = ChartFactory.createPieChart(
                "Género de Alumnos ",
                data,
                true,
                false,
                true);
        //Meter La grafica en un Panel
        cp = new ChartPanel(chart);
        cp.setLayout(new java.awt.BorderLayout(6500, 6500));
        cp.setBounds(850, 180, 600, 500);
        cp.setVisible(true);
        cp.validate();
        this.add(cp);

        // Mostrar Grafico
        // ChartFrame frame = new ChartFrame("JFreeChart", chart);
       /* frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
     */
}
