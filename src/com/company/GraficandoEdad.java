package com.company;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GraficandoEdad extends Thread {

    int R1 = 0;
    int R2 = 0;
    int R3 = 0;
    int R4 = 0;
    int R5 = 0;
    int R6 = 0;
    int R7 = 0;
    int R8 = 0;
    int R9 = 0;
    int R10 = 0;

        public GraficandoEdad(int idCurso) {
            this.idCurso = idCurso;
        }

        int idCurso;



        public void run() {


            try {



                for (int i = 0; i < Main.contadorNotas; i++) {
                    if (idCurso == Main.notas[i].getIdcurso()) {
                        System.out.println("Nombre :" + Main.BuscarAlumnoPorId(Main.notas[i].getIdalumno()) + " nota  :" + Main.notas[i].getNota());
                        System.out.println("Edad " + Main.BuscaEdadDelAlumno(Main.notas[i].getIdalumno()));

                        if (Main.BuscaEdadDelAlumno(Main.notas[i].getIdalumno()) > 0 && Main.BuscaEdadDelAlumno(Main.notas[i].getIdalumno()) <= 10 ) {
                            R1++;
                            GraficaEdad.data.setValue(R1,"0-10","");
                        }

                        if (Main.BuscaEdadDelAlumno(Main.notas[i].getIdalumno()) > 10 && Main.BuscaEdadDelAlumno(Main.notas[i].getIdalumno()) <= 20 ) {
                            R2++;
                            GraficaEdad.data.setValue(R2,"10-20","");
                        }

                        if (Main.BuscaEdadDelAlumno(Main.notas[i].getIdalumno()) > 20 && Main.BuscaEdadDelAlumno(Main.notas[i].getIdalumno()) <= 30 ) {
                            R3++;
                            GraficaEdad.data.setValue(R3,"20-30","");
                        }

                        if (Main.BuscaEdadDelAlumno(Main.notas[i].getIdalumno()) > 30 && Main.BuscaEdadDelAlumno(Main.notas[i].getIdalumno()) <= 40 ) {
                            R4++;
                            GraficaEdad.data.setValue(R4,"30-40","");
                        }

                        if (Main.BuscaEdadDelAlumno(Main.notas[i].getIdalumno()) > 40 && Main.BuscaEdadDelAlumno(Main.notas[i].getIdalumno()) <= 50 ) {
                            R5++;
                            GraficaEdad.data.setValue(R5,"40-50","");
                        }

                        if (Main.BuscaEdadDelAlumno(Main.notas[i].getIdalumno()) > 50 && Main.BuscaEdadDelAlumno(Main.notas[i].getIdalumno()) <= 60 ) {
                            R6++;
                            GraficaEdad.data.setValue(R6,"50-60","");
                        }

                        if (Main.BuscaEdadDelAlumno(Main.notas[i].getIdalumno()) > 60 && Main.BuscaEdadDelAlumno(Main.notas[i].getIdalumno()) <= 70 ) {
                            R7++;
                            GraficaEdad.data.setValue(R7,"60-70","");
                        }

                        if (Main.BuscaEdadDelAlumno(Main.notas[i].getIdalumno()) > 70 && Main.BuscaEdadDelAlumno(Main.notas[i].getIdalumno()) <= 80 ) {
                            R8++;
                            GraficaEdad.data.setValue(R8,"70-80","");
                        }

                        if (Main.BuscaEdadDelAlumno(Main.notas[i].getIdalumno()) > 80 && Main.BuscaEdadDelAlumno(Main.notas[i].getIdalumno()) <= 90 ) {
                            R9++;
                            GraficaEdad.data.setValue(R9,"80-90","");
                        }

                        if (Main.BuscaEdadDelAlumno(Main.notas[i].getIdalumno()) > 90 && Main.BuscaEdadDelAlumno(Main.notas[i].getIdalumno()) <= 100 ) {
                            R10++;
                            GraficaEdad.data.setValue(R10,"90-100","");
                        }

                        sleep(500);
                    }

                }
                this.stop();
            }catch (InterruptedException ex){
                Logger.getLogger(Graficando.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
}
