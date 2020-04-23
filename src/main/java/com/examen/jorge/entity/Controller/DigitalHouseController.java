package com.examen.jorge.entity.Controller;

import com.examen.jorge.entity.DigitalHouseManager;
import com.examen.jorge.entity.ProfesorTitular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DigitalHouseController {

    @Autowired
    private DigitalHouseManager digitalHouseManager;

    @PostMapping("/crearTitular")
    public void creatTitular(@RequestBody ProfesorTitular pt){
        digitalHouseManager.altaProfesorTitular(pt.getNombre(), pt.getApellido(),
                                pt.getCodigo(), pt.getEspecialidad());
    }
}