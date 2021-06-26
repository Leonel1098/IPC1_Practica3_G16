package com.company;

public class Asignaciones {
    private int IDAlumno,IDCurso;
    private float NotaAlumno;
    public Asignaciones(int IDAlumno, int IDCurso, float NotaAlumno)
    {
        this.IDAlumno=IDAlumno;
        this.IDCurso=IDCurso;
        this.NotaAlumno=NotaAlumno;

    }
public int getIDAlumno(){
        return IDAlumno;
}
public int getIDCurso(){
        return IDCurso;
}
public float getNotaAlumno(){
        return NotaAlumno;
}

}
