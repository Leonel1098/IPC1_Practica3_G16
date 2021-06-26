package com.company;

public class Qsortclass extends Thread{
    public  Asignación[] p;
    public int L,H;
    public static grafica h = new grafica();
   public static Qsortclass u,k;
   public int IdCurso, Velocidad;
    public Qsortclass(Asignación[] p,int L, int  H, int IdCurso, int Velocidad)
    {
        this.p=p;
        this.L=L;
        this.H=H;
        this.IdCurso = IdCurso;
        this.Velocidad = Velocidad;

    }
    Asignación temp;


    @Override
    public void run() {
        try {
            h.setVisible(true);
           if (L>=H) { for (Asignación j : p) {

               if (j!=null) {
                   if (IdCurso == j.getIdcurso()) {

                       h.datos.setValue(j.getNota(), Main.nombre(j.getIdalumno()), Main.curso(j.getIdcurso()));
                       h.pack();
                       h.repaint();
                       // g.datos.clear();



                   }
               }

           }
               for (Asignación j: p) System.out.println(j.getNota());
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
                    while (p[H].getNota()>=p[L].getNota()  && L<H) H--;
                    while (p[L].getNota()<p[pivote].getNota() && L<H) L++;
                    if (H!=L)
                    {
                        temp = p[H];
                        p[H]=p[L];
                        p[L]=temp;
                    }
                    if (L==H)
                    {

                         u = new Qsortclass(p, i, L - 1, IdCurso, Velocidad);
                         p= u.p;
                         k=new Qsortclass(p,L+1,d, IdCurso, Velocidad);
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



        }


            for (Asignación j : p) {

                if (j!=null) {
                    if (IdCurso == j.getIdcurso()) {

                        h.datos.setValue(j.getNota(), Main.nombre(j.getIdalumno()), Main.curso(j.getIdcurso()));
                        h.pack();
                        h.repaint();
                        sleep(Velocidad);

                        // g.datos.clear();


                    }
                }

            }
        }



        catch (InterruptedException e){


        }
    }

}
