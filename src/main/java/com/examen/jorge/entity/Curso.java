package com.examen.jorge.entity;

import java.util.ArrayList;

public class Curso {
    private String nombre;
    private Integer codigo;
    private Integer cupoMaximo;
    private ProfesorTitular profesorTitular;
    private ProfesorAdjunto profesorAdjunto;
    private List<Alumno> inscriptos;

    public Curso(String nombre, Integer codigo, Integer cupoMaximo){
        this.nombre = nombre;
        this.codigo = codigo;
        this.cupoMaximo = cupoMaximo;
        this.alumnos = new ArrayList<>();
    }

    public boolean compararCurso(Object obj){
        if( !(obj instanceof Curso)){ return false; }
        Curso c = (Curso) obj;
        if(this.codigo.equals(c.getCodigo())) return true;
        else return false;
    }

    public boolean agregarUnAlumno(Alumno unAlumno){
        if( this.cupoMaximo >= this.inscriptos.size() ){
            return false
        } else {
            this.inscriptos.add(unAlumno);
            return true;
        }
    }

    public String getNombre(){ return this.nombre; }
    public void setNombre(String nombre){ this.nombre = nombre; }
    public Integer getCodigo(){return this.codigo; }
    public void setCodigo(Integer codigo){ this.codigo = codigo; }
    public Integer getCupoMaximo(){ return this.cupoMaximo; }
    public void setCupoMaximo(Integer cupoMaximo){ this.cupoMaximo = cupoMaximo; }
    public ProfesorTitular getProfesorTitular(){return this.profesorTitular;}
    public void setProfesorTitular(ProfesorTitular profesorTitular){ this.profesorTitular = profesorTitular;}
    public ProfesorAdjunto getProfesorAdjunto(){ return this.profesorAdjunto; }
    public void setProfesorAdjunto(ProfesorAdjunto profesorAdjunto){ this.profesorAdjunto = profesorAdjunto;}
    public List<Alumno> getInscriptos(){ return this.inscriptos; }
}