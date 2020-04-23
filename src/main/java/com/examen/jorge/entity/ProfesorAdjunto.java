package com.examen.jorge.entity;

public class ProfesorAdjunto extends Profesor{
    private Integer cantidadHoras;
    
    public ProfesorAdjunto(String nombre, String apellido, 
                    Integer antiguedad, Integer codigo, Integer cantidadHoras){
        super(nombre, apellido, antiguedad, codigo);
        this.cantidadHoras = cantidadHoras;
    }

    public Integer getCantidadHoras(){ return this.cantidadHoras; }
    public void setCantidadHoras(Integer cantidadHoras){ this.cantidadHoras = cantidadHoras; }

    public String toString(){
        return super.toString() + " " + this.cantidadHoras;
    }
}