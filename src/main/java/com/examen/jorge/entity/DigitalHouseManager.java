package com.examen.jorge.entity;

import java.util.ArrayList;
import java.util.List;

public class DigitalHouseManager {
    public static List<Alumno> alumnos;
    public static List<Profesor> profesores;
    public static List<Inscripcion> inscripciones;

    public static DigitalHouseManager(){
        this.alumnos = new ArrayList<>();
        this.profesores = new ArrayList<>();
        this.inscripciones = new ArrayList<>();
    }
}