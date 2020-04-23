package com.examen.jorge.entity;

public class Profesor {
    private String nombre;
    private String apellido;
    private Integer antiguedad;
    private Integer codigo;

    public Profesor(String nombre, String apellido, Integer antiguedad, Integer codigo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.antiguedad = antiguedad;
        this.codigo = codigo;
    }

    public boolean compararProfesor(Object obj){
        if( !(obj instanceof Profesor)){ return false; }
        Profesor p = (Profesor) obj;
        if( this.codigo.equals(p.getCodigo())) return true;
        else return false;
    }

    public String getNombre(){ return this.nombre;}
    public void setNombre(String nombre){ this.nombre = nombre; }
    public String getApellido(){ return this.apellido; }
    public void setApellido(String apellido){ this.apellido = apellido; }
    public Integer getAntiguedad(){ return this.antiguedad; }
    public void setAntiguedad(Integer antiguedad){ this.antiguedad = antiguedad; }
    public Integer getCodigo(){ return this.codigo; }
    public void setCodigo(Integer codigo){ this.codigo = codigo; }

    public String toString(){
        return "nombre: " + this.nombre + ", apellido: " + this.apellido + 
                ", antiguedad: "+ this.antiguedad + ", codigo: " + this.codigo;
    }
}