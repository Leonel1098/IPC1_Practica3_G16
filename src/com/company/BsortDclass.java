package com.company;

public class BsortDclass extends Thread{
    public  Asignación[] p;
    public static grafica h = new grafica();
    public BsortDclass(Asignación[] p)
    {
        this.p=p;
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
                for (int i = 1; i<p.length;i++)
                {
                    if (p[i].getNota()>p[i-1].getNota()){
                        temp = p[i];
                        p[i]=p[i-1];
                        p[i-1]=temp;
                        t=true;

                    }
                }
                if (t==false) {
                    for (Asignación j : p) {

                        if ("Machamachacas".equals(Main.curso(j.getIdcurso()))) {

                            h.datos.setValue(j.getNota(), Main.nombre(j.getIdalumno()), Main.curso(j.getIdcurso()));
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
