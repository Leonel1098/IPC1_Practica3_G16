package com.company;
import javafx.scene.chart.ScatterChart;
import org.jfree.data.general.Dataset;

import java.awt.*;
import java.rmi.Remote;

public class BsortAclass extends Thread{
public  Asignación[] p;
public  int IdCurso;
    public static grafica g = new grafica();
public BsortAclass(Asignación[] p, int IdCurso)
{
    this.p=p;
    this.IdCurso = IdCurso;
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
                    if (p[i].getNota() < p[i - 1].getNota()) {
                        temp = p[i];
                        System.out.println("ENtra");
                        System.out.println(IdCurso);
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
                    sleep(100);



                }
                if (t == false) {
                    for (Asignación j : p) {

                        if (IdCurso == j.getIdcurso()) {

                            g.datos.setValue(j.getNota(), Main.nombre(j.getIdalumno()), Main.curso(j.getIdcurso()));

                            g.pack();
                            g.repaint();

                            // g.datos.clear();


                        }

                    }

                }
               // sleep(1000);

                sleep(100);
            }



        }
        catch (InterruptedException e){
            for (Asignación j : p) {

                if ( IdCurso ==Integer.parseInt(Main.curso(j.getIdcurso()))) {

                    g.datos.setValue(j.getNota(), Main.nombre(j.getIdalumno()), Main.curso(j.getIdcurso()));

                    g.pack();
                    g.repaint();

                    // g.datos.clear();


                }

            }

        }
    }



}
