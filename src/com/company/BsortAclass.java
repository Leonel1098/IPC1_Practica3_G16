package com.company;
import javafx.scene.chart.ScatterChart;
import org.jfree.data.general.Dataset;

import java.awt.*;
import java.rmi.Remote;

public class BsortAclass extends Thread{
public  Asignación[] p;
public  int IdCurso;
public  int Velocidad;
public int pasos;
    public static grafica g = new grafica();
public BsortAclass(Asignación[] p, int IdCurso, int Velocidad)
{
    this.p=p;
    this.IdCurso = IdCurso;
    this.Velocidad = Velocidad;
    this.pasos = 0;
}
Asignación temp;


    @Override
    public void run() {
        try {

            g.setVisible(true);

            boolean t = false;
            while (true) {

                t = false;
                for (int i = 1; i < p.length; i++) {
                    if (p[i] != null){
                        if (p[i].getNota() < p[i - 1].getNota()) {
                            temp = p[i];
                            System.out.println("ENtra");
                            p[i] = p[i - 1];
                            p[i - 1] = temp;
                            t = true;
                     /*  for (Asignaciones j : p) {
                           if ("Machamachacas".equals(Main.curso(j.getIDCurso()))) {

                               g.datos.addValue(j.getNotaAlumno(), Main.nombre(j.getIDAlumno()), Main.curso(j.getIDCurso()));
                                System.out.println("pasa por aca");

                            }
                            g.pack();
                            g.repaint();
                        }*/


                        }
                }



                }
                if (t == false) {
                    for (Asignación j : p) {
                        if (j != null) {
                            if (IdCurso == j.getIdcurso()) {

                                g.datos.setValue(j.getNota(), Main.nombre(j.getIdalumno()), Main.curso(j.getIdcurso()));

                                g.pack();
                                g.repaint();
                                sleep(Velocidad);
                                pasos++;
                                // g.datos.clear();


                            }
                        }

                    }
                    String Pa = String.valueOf(pasos);

                    if (Velocidad == 1500) {
                        Datos Dt = new Datos("BubbleSort", "Lenta", Pa, "Ascendente");
                        Dt.setVisible(true);
                    }else if (Velocidad == 800) {
                        Datos Dt = new Datos("BubbleSort", "Media", Pa, "Ascendente");
                        Dt.setVisible(true);
                    }else if (Velocidad == 300) {
                        Datos Dt = new Datos("BubbleSort", "Rapida", Pa, "Ascendente");
                        Dt.setVisible(true);
                    }

                    Crono.ejecutar = false;
                    this.stop();
                    ;

                }
               // sleep(1000);


            }



        }
        catch (InterruptedException e){
            for (Asignación j : p) {

                if ( IdCurso == j.getIdcurso()) {

                    g.datos.setValue(j.getNota(), Main.nombre(j.getIdalumno()), Main.curso(j.getIdcurso()));

                    g.pack();
                    g.repaint();

                    // g.datos.clear();


                }

            }

        }
    }



}
