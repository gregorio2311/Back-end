package com.fcm.backend.repository;

import com.fcm.backend.repository.entity.Alumno;

import java.util.List;

public interface AlumnoRepository {

    void insertar(Alumno alumno);

    Alumno getAlumnoById(Long id);

    List<Alumno> getAlumnoList();

    Alumno updateAlumno(Long id, Alumno alumnoActualizado);

    void deleteAlumno(Long id);

}
