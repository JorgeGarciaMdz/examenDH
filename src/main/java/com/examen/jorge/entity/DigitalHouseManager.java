package com.examen.jorge.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DigitalHouseManager {
    public static List<Alumno> alumnos = new ArrayList<>();
    public static List<Profesor> profesores = new ArrayList<>();
    public static List<Inscripcion> inscripciones = new ArrayList<>();
    public static List<Curso> cursos = new ArrayList<>();

    public void altaCurso(String nombre, Integer codigo, Integer cupoMaximo){
        Curso curso = new Curso(nombre, codigo, cupoMaximo);
        cursos.add(curso);
    }

    public void bajaCurso(Integer codigoCurso){
        Optional<Curso> c = Optional.empty();
        boolean isPresent = cursos.stream()
                                .filter(cs -> cs.getCodigo().equals(codigoCurso))
                                .findFirst()
                                .isPresent();
        if( isPresent){
            c = cursos.stream()
                .filter(cs -> cs.getCodigo().equals(codigoCurso))
                .findFirst();
            cursos.remove(c.get());
        }
    }

    public void altaProfesorAjunto(String nombre, String apellido, Integer codigo, Integer cantidadHoras){
        profesores.add(new ProfesorAdjunto(nombre, apellido, 0, codigo, cantidadHoras));
    }

    public void altaProfesorTitular(String nombre, String apellido, Integer codigo, String especialidad){
        profesores.add(new ProfesorTitular(nombre, apellido, 0, codigo, especialidad));
    }
    
    public void bajaProfesor(Integer codigoProfesor){
        boolean isPresent = profesores.stream()
                            .filter(p -> p.getCodigo().equals(codigoProfesor))
                            .findFirst().isPresent();
        if(isPresent){
            Optional<Profesor> prof = profesores.stream()
                                        .filter(p -> p.getCodigo().equals(codigoProfesor))
                                        .findFirst();
            profesores.remove(prof.get());
        }
    }

    public void altaAlumno(String nombre, String apellido, Integer codigo){
        alumnos.add(new Alumno(nombre, apellido, codigo));
    }

    public void inscribirAlumno(Integer codigoAlumno, Integer codigoCurso){
        boolean isPresentCurso = cursos.stream()
                                    .filter( c -> c.getCodigo().equals(codigoCurso))
                                    .findFirst().isPresent();
        boolean isPresentAlumno = alumnos.stream()
                                    .filter( a -> a.getCodigo().equals(codigoAlumno))
                                    .findFirst().isPresent();
        if( isPresentAlumno && isPresentCurso){
            Optional<Curso> curs = cursos.stream()
                                        .filter( c -> c.getCodigo().equals(codigoCurso))
                                        .findFirst();
            int indexCurso = cursos.indexOf(curs.get());
            Optional<Alumno> alum = alumnos.stream()
                                        .filter(a -> a.getCodigo().equals(codigoAlumno))
                                        .findFirst();
            Curso c = curs.get();
            if( c.hayCupo()){
                Inscripcion i = new Inscripcion(alum.get(), c);
                inscripciones.add(i);  // realizo inscripcion
                c.agregarUnAlumno(alum.get());  // agrego alumno al curso
                cursos.add(indexCurso, c);  // actualizo el curso en la lista
                System.out.println("Incripcion: " + i.toString());

            } else{
                System.out.println("No hay cupos disponibles en el curso: " + c.toString() );
            }
        }
    }

    public void asignarProfesor(Integer codigoCurso, Integer codigoProfesorTitular, Integer codigoProfesorAdjunto){
        boolean adj = profesores.stream().filter(p -> p.getCodigo().equals(codigoProfesorAdjunto))
                        .findFirst().isPresent();
        boolean tit = profesores.stream().filter(p -> p.getCodigo().equals(codigoProfesorTitular))
                        .findFirst().isPresent();
        boolean cur = cursos.stream().filter( c -> c.getCodigo().equals(codigoCurso))
                        .findFirst().isPresent();
        if(adj && tit && cur){
            Optional<Profesor> profTit = profesores.stream()
                                                .filter( p -> p.getCodigo().equals(codigoProfesorTitular))
                                                .findFirst();
            Optional<Profesor> profAdj = profesores.stream()
                                                .filter( p -> p.getCodigo().equals(codigoProfesorAdjunto))
                                                .findFirst();
            Optional<Curso> curs = cursos.stream().filter( c -> c.getCodigo().equals(codigoCurso))
                                            .findFirst();
            int index = cursos.indexOf(curs.get());
            Curso c = curs.get();
            c.setProfesorAdjunto((ProfesorAdjunto) profAdj.get());
            c.setProfesorTitular((ProfesorTitular) profTit.get());
            cursos.add(index, c);
        }
    }
}