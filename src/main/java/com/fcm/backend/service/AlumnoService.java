package com.fcm.backend.service;

import com.fcm.backend.model.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {


    void createAlumno(Alumno newAlumno);
    List<Alumno> getAlumnoList();
    Alumno getAlumnoById(int id);

    Optional<Alumno> updateAlumno(int idAlumno, Alumno alumnoActualizado);

    boolean deleteAlumno(int idAlumno);
}
