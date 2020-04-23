package com.examen.jorge.entity;

import java.util.Date;

public class Inscripcion {
    private Alumno alumno;
    private Curso curso;
    private Date fechaInscripcion;

    public Inscripcion(Alumno alumno, Curso curso){
        this.alumno = alumno;
        this.curso = curso;
        this.fechaInscripcion = new Date();
    }

    public Alumno getAlumno(){ return this.alumno; }
    public void setAlumno(Alumno alumno){ this.alumno = alumno; }
    public Curso getCurso(){return this.curso; }
    public void setCurso(Curso curso){ this.curso = curso; }
    public Date getFechaInscripcion(){ return this.fechaInscripcion; }

    public String toString(){
        return "Alumno: " + this.alumno.toString() + 
                "Curso: " + this.curso.toString() + 
                "Fecha inscripcion: " + this.fechaInscripcion.toString();
    }
}