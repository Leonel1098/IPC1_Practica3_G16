package com.company;

public class Asignación {
    private int Idalumno;
    private int Idcurso;
    private double nota;

    public Asignación(int idalumno, int idcurso, double nota){
        this.Idalumno = idalumno;
        this.Idcurso = idcurso;
        this.nota = nota;

    }


    public int getIdalumno() {
        return Idalumno;
    }

    public void setIdalumno(int idalumno) {
        Idalumno = idalumno;
    }

    public int getIdcurso() {
        return Idcurso;
    }

    public void setIdcurso(int idcurso) {
        Idcurso = idcurso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
