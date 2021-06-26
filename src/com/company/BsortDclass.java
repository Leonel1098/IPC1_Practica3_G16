package com.company;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BsortDclass extends Thread{
    public  Asignación[] p;
    public static grafica h = new grafica();
    public int IdCurso;
    public int Velocidad;
    public int pasos;
    public BsortDclass(Asignación[] p, int IdCurso, int Velocidad)
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
            h.setVisible(true);
            boolean t = false;
            while (true)
            {
                t = false;
                for (int i = 1; i<p.length;i++) {
                    if (p[i] != null) {
                        if (p[i].getNota() > p[i - 1].getNota()) {
                            temp = p[i];
                            p[i] = p[i - 1];
                            p[i - 1] = temp;
                            t = true;

                        }
                    }
                }
                if (t==false) {
                    for (Asignación j : p) {

                        if (j != null) {
                            if (IdCurso == j.getIdcurso()) {

                                h.datos.setValue(j.getNota(), Main.nombre(j.getIdalumno()), Main.curso(j.getIdcurso()));
                                h.pack();
                                h.repaint();
                                sleep(Velocidad);
                                pasos++;
                                // g.datos.clear();


                            }
                        }
                    }
                    String Pa = String.valueOf(pasos);

                    if (Velocidad == 1500) {
                        Datos Dt = new Datos("BubbleSort", "Lenta", Pa, "Descendente");
                        Dt.setVisible(true);
                    }else if (Velocidad == 800) {
                        Datos Dt = new Datos("BubbleSort", "Media", Pa, "Descendente");
                        Dt.setVisible(true);
                    }else if (Velocidad == 300) {
                        Datos Dt = new Datos("BubbleSort", "Rapida", Pa, "Descendente");
                        Dt.setVisible(true);
                    }
                    Crono.ejecutar = false;
                    this.stop();


                }
            }
        }


        catch (InterruptedException ex){
            Logger.getLogger(Graficando.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}
