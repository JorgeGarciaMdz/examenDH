package com.examen.jorge.entity;


public class Alumno {
    private String nombre;
    private String apellido;
    private Integer codigo;

    public Alumno(String nombre, String apellido, Integer codigo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
    }

    public boolean compararAlumno(Object obj){
        if( !(obj instanceof Alumno)){ return false; }
        Alumno a = (Alumno) obj;
        if( this.codigo.equals(a.getCodigo())){ return true; }
        else return false; 
    }

    public String getNombre(){ return this.nombre; }
    public void setNombre(String nombre){ this.nombre = nombre; }
    public String getApellido(){ return this.apellido; }
    public void setApellido(String apellido){ this.apellido = apellido; }
    public Integer getCodigo(){return this.codigo; }
    public void setCodigo(Integer codigo){this.codigo = codigo; }

    public String toString(){
        return "nombre: " + this.nombre + ", apellido: " + this.apellido +
                ", codigo: " + this.codigo;
    }

}