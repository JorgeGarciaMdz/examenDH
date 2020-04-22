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
}