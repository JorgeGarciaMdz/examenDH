package com.examen.jorge.entity.Controller;

import java.util.List;

import com.examen.jorge.entity.Alumno;
import com.examen.jorge.entity.Curso;
import com.examen.jorge.entity.DigitalHouseManager;
import com.examen.jorge.entity.ProfesorAdjunto;
import com.examen.jorge.entity.ProfesorTitular;
import com.examen.jorge.entity.Pojos.AsignarProfesors;
import com.examen.jorge.entity.Pojos.InscAlumno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/")
public class DigitalHouseController {

    @Autowired
    private DigitalHouseManager digitalHouseManager;

    @PostMapping("/crearTitular")
    public void creatTitular(@RequestBody ProfesorTitular pt){
        digitalHouseManager.altaProfesorTitular(pt.getNombre(), pt.getApellido(),
                                pt.getCodigo(), pt.getEspecialidad());
        log.info("array profesores " + digitalHouseManager.profesores);
    }

    @PostMapping("/crearAdjunto")
    public void crearAdjunto(@RequestBody ProfesorAdjunto pt){
        digitalHouseManager.altaProfesorAjunto(pt.getNombre(), pt.getApellido(),
                                pt.getCodigo(), pt.getCantidadHoras());
        log.info("array profesores " + digitalHouseManager.profesores );
    }

    @PostMapping("/crearCurso")
    public void crearCurso(@RequestBody Curso curso){
        log.info("cursos");
        digitalHouseManager.altaCurso(curso.getNombre(), curso.getCodigo(), curso.getCupoMaximo());
        log.info("Arrays cursos: " + digitalHouseManager.cursos);
    }

    @PostMapping("/asignarProfesor")
    public void asignarProfesor(@RequestBody AsignarProfesors ap){
        log.info("Asinando: " + ap.toString());
        digitalHouseManager.asignarProfesor(ap.getCodigoCurso(), ap.getCodigoProfesorTitular(),
                        ap.getCodigoProfesorAdjunto());
        log.info("asignacion profesores: " + digitalHouseManager.profesores);  
        
    }

    @DeleteMapping("/bajaProfesor/{codigo}")
    public void bajaProfesor(@PathVariable (name = "codigo") Integer codigo){
        log.info("Baja profesor codigo: " + codigo);
        log.info("Array profesor antes: " + digitalHouseManager.profesores);
        digitalHouseManager.bajaProfesor(codigo);
        log.info("Array profesor despues: " + digitalHouseManager.profesores);

    }

    @PostMapping("/altaAlumno")
    public void altaAlumno(@RequestBody Alumno a){
        log.info("Dando de alta a alumno: " + a);
        digitalHouseManager.altaAlumno(a.getNombre(), a.getApellido(), a.getCodigo());
        log.info("alumnos en arrays: "+ digitalHouseManager.alumnos);
    }

    @PostMapping("/inscribirAlumno")
    public void inscribirAlumno(@RequestBody List<InscAlumno> ia){
        log.info("Inscribir alumnos con codigos: " + ia.toString());
        for(InscAlumno i : ia){
            digitalHouseManager.inscribirAlumno(i.getCodigoAlumno(), i.getCodigoCurso());
        }
        log.info("alumnos inscriptos: " + digitalHouseManager.alumnos);
    }

    @GetMapping("/detalleAlumno/{codigo}")
    public Alumno detalleAlumno(@PathVariable (name = "codigo") Integer codigo){
        log.info("find alumno with codigo: " + codigo);
        log.info("Alumno: " + digitalHouseManager.findAlumno(codigo));
        return digitalHouseManager.findAlumno(codigo);
    }

    @PutMapping("/actualizarAlumno")
    public void actualizarAlumno(@RequestBody Alumno al){
        log.info("actualizar alumno con: " + al);
        digitalHouseManager.updateAlumno(al);
    }
}