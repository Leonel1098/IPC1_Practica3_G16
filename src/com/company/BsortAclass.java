package com.company;
import javafx.scene.chart.ScatterChart;
import org.jfree.data.general.Dataset;

import java.awt.*;
import java.rmi.Remote;

public class BsortAclass extends Thread{
public  Asignaciones[] p;
    public static grafica g = new grafica();
public BsortAclass(Asignaciones[] p)
{
    this.p=p;
}
Asignaciones temp;


    @Override
    public void run() {
        try {

            g.setVisible(true);

            boolean t = false;
            while (true) {

                t = false;
                for (int i = 1; i < p.length; i++) {
                    if (p[i].getNotaAlumno() < p[i - 1].getNotaAlumno()) {
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
                    sleep(100);



                }
                if (t == false) {

                }
               // sleep(1000);

                sleep(100);
            }



        }
        catch (InterruptedException e){
            for (Asignaciones j : p) {

                if ("Machamachacas".equals(Main.curso(j.getIDCurso()))) {

                    g.datos.setValue(j.getNotaAlumno(), Main.nombre(j.getIDAlumno()), Main.curso(j.getIDCurso()));

                    g.pack();
                    g.repaint();

                    // g.datos.clear();


                }

            }

        }
    }



}
