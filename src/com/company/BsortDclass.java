package com.company;

public class BsortDclass extends Thread{
    public  Asignaciones[] p;
    public static grafica h = new grafica();
    public BsortDclass(Asignaciones[] p)
    {
        this.p=p;
    }
    Asignaciones temp;


    @Override
    public void run() {
        try {
            h.setVisible(true);
            boolean t = false;
            while (true)
            {
                t = false;
                for (int i = 1; i<p.length;i++)
                {
                    if (p[i].getNotaAlumno()>p[i-1].getNotaAlumno()){
                        temp = p[i];
                        p[i]=p[i-1];
                        p[i-1]=temp;
                        t=true;

                    }
                }
                if (t==false) {
                    for (Asignaciones j : p) {

                        if ("Machamachacas".equals(Main.curso(j.getIDCurso()))) {

                            h.datos.setValue(j.getNotaAlumno(), Main.nombre(j.getIDAlumno()), Main.curso(j.getIDCurso()));
                            h.pack();
                            h.repaint();
                            // g.datos.clear();


                        }
                    }
                    sleep(100);
                }
            }

            }

        catch (InterruptedException e){


        }
    }


}
