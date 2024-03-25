package com.fcm.backend.service;

import com.fcm.backend.model.Alumno;

import java.util.List;

public interface AlumnoService {


    void createAlumno(Alumno newAlumno);
    List<Alumno> getAlumnoList();
    Alumno getAlumnoById(int id);
}
