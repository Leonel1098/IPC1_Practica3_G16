package com.company;

public class Alumno {
    private int id ;
    private int carnet;
    private String nombre;
    private String fechanacimiento;
    private String Genero;
    public Alumno(int id , int carnet, String nombre , String fechanacimiento, String Genero){
        this.id=id;
        this.carnet=carnet;
        this.nombre=nombre;
        this.fechanacimiento=fechanacimiento;
        this.Genero=Genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        fechanacimiento = fechanacimiento;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }
}
