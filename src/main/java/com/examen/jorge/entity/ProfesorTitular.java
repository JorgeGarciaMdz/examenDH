package com.examen.jorge.entity;


public class ProfesorTitular extends Profesor{
    private String especialidad;

    public ProfesorTitular(String nombre, String apellido, 
                        Integer antiguedad, Integer codigo, String especialidad){
        super(nombre, apellido, antiguedad, codigo);
        this.especialidad = especialidad;
    }

    public String getEspecialidad(){ return this.especialidad; }
    public void setEspecialidad(String especialidad){ this.especialidad = especialidad; }

    public String toString(){
        return super.toString() + " " + this.especialidad;
    }
}