package com.fcm.backend.utils;

import com.fcm.backend.repository.entity.Alumno;

import java.sql.Date;

public class AlumnoMapper {
    public static  com.fcm.backend.model.Alumno alumnoEntityToAlumnoModel(Alumno alumno){
        com.fcm.backend.model.Alumno model = new com.fcm.backend.model.Alumno();
        model.setPrimerNombre(alumno.getPrimerNombre());
        model.setSegundoNombre(alumno.getSegundoNombre());
        model.setApellidoPat(alumno.getApellidoPat());
        model.setApellidoMat(alumno.getApellidoMat());
        model.setFechaNac(alumno.getFechaNac().toString());
        model.setCurp(alumno.getCurp());
        model.setEmail(alumno.getEmail());
        return model;
    }

    public static Alumno alumnoModelToAlumnoEntity(com.fcm.backend.model.Alumno alumno){
        Alumno entity = new com.fcm.backend.repository.entity.Alumno();
        entity.setPrimerNombre(alumno.getPrimerNombre());
        entity.setSegundoNombre(alumno.getSegundoNombre());
        entity.setApellidoPat(alumno.getApellidoPat());
        entity.setApellidoMat(alumno.getApellidoMat());
        entity.setCurp(alumno.getCurp());
        entity.setEmail(alumno.getEmail());
        entity.setFechaNac(Date.valueOf(alumno.getFechaNac()));
        return entity;
    }
}
