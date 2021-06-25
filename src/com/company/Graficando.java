package com.company;

import javax.swing.*;

import static com.company.GraficaGenero.data;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Graficando extends Thread {

    public Graficando(int idCurso) {
        this.idCurso = idCurso;
    }

    int idCurso;



    public void run() {



                try {

                    int m=0;
                    int f=0;
                    for (int i = 0; i < Main.contadorNotas; i++) {
                        sleep(100);
                        if (idCurso == Main.notas[i].getIdcurso()) {
                            System.out.println("Nombre :" + Main.BuscarAlumnoPorId(Main.notas[i].getIdalumno()) + " nota  :" +
                                    Main.notas[i].getNota());
                            System.out.println("Sexo " +Main. BuscaSexoDelAlumno(Main.notas[i].getIdalumno()));
                            if (Main.BuscaSexoDelAlumno(Main.notas[i].getIdalumno()).equals("M")) {
                                m++;
                                data.setValue("Masculino", m);
                               ;
                            }
                            if (Main.BuscaSexoDelAlumno(Main.notas[i].getIdalumno()).equals("F")) {
                                f++;
                                data.setValue("Femenino ", f);

                            }



                        }


                    }

                    this.stop();


                } catch (InterruptedException ex) {
                    Logger.getLogger(Graficando.class.getName()).log(Level.SEVERE, null, ex);
                }




    }

}

