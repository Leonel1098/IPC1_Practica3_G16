package com.company;

public class Qsortclass extends Thread{
    public  Asignaciones[] p;
    public int L,H;
    public static grafica h = new grafica();
   public static Qsortclass u,k;
    public Qsortclass(Asignaciones[] p,int L, int  H)
    {
        this.p=p;
        this.L=L;
        this.H=H;
    }
    Asignaciones temp;


    @Override
    public void run() {
        try {
            h.setVisible(true);
           if (L>=H) { for (Asignaciones j : p) {

               if ("Machamachacas".equals(Main.curso(j.getIDCurso()))) {

                   h.datos.setValue(j.getNotaAlumno(), Main.nombre(j.getIDAlumno()), Main.curso(j.getIDCurso()));
                   h.pack();
                   h.repaint();

                   // g.datos.clear();


               }

           }
               for (Asignaciones j: p) System.out.println(j.getNotaAlumno());
           }
           else {
            int i = L, d = H;

            if (L!=H)
            {
                int pivote;
                float aux;
                pivote = L;
                while (L!=H)
                {
                    while (p[H].getNotaAlumno()>=p[L].getNotaAlumno()  && L<H) H--;
                    while (p[L].getNotaAlumno()<p[pivote].getNotaAlumno() && L<H) L++;
                    if (H!=L)
                    {
                        temp = p[H];
                        p[H]=p[L];
                        p[L]=temp;
                    }
                    if (L==H)
                    {

                         u = new Qsortclass(p, i, L - 1);
                         p= u.p;
                         k=new Qsortclass(p,L+1,d);
                         p=k.p;
                    }
                }
            }
            else /* for (Asignaciones j : p) {

                if ("Machamachacas".equals(Main.curso(j.getIDCurso()))) {

                    h.datos.setValue(j.getNotaAlumno(), Main.nombre(j.getIDAlumno()), Main.curso(j.getIDCurso()));
                    h.pack();
                    h.repaint();

                    // g.datos.clear();


                }

            }*/System.out.println("adf");

           sleep(100);
        }


            for (Asignaciones j : p) {

                if ("Machamachacas".equals(Main.curso(j.getIDCurso()))) {

                    h.datos.setValue(j.getNotaAlumno(), Main.nombre(j.getIDAlumno()), Main.curso(j.getIDCurso()));
                    h.pack();
                    h.repaint();

                    // g.datos.clear();


                }

            }
        }



        catch (InterruptedException e){


        }
    }

}
