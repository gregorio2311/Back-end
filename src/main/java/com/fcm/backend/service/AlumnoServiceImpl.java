package com.fcm.backend.service;

import com.fcm.backend.model.Alumno;
import com.fcm.backend.repository.AlumnoRepository;
import com.fcm.backend.utils.AlumnoMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    List<Alumno> alumnoList = new ArrayList<>();

    private AlumnoRepository alumnoRepository;

    @Autowired
    AlumnoServiceImpl(AlumnoRepository alumnoRepository){this.alumnoRepository = alumnoRepository;}

    @Override
    public List<Alumno> getAlumnoList(){
        List<com.fcm.backend.repository.entity.Alumno> entityList = alumnoRepository.getAlumnoList();
        List<Alumno> modelList = entityList.stream().map(AlumnoMapper::alumnoEntityToAlumnoModel).collect(Collectors.toList());
        return modelList;
    }


    public void createAlumno(Alumno newAlumno) {

        alumnoRepository.insertar(AlumnoMapper.alumnoModelToAlumnoEntity(newAlumno));
    }

    @Override
    public Optional<Alumno> getAlumnoById(int idAlumno) {
        com.fcm.backend.repository.entity.Alumno alumnoEntity = alumnoRepository.getAlumnoById(Long.valueOf(idAlumno));
        if (alumnoEntity != null) {
            Alumno alumnoModel = AlumnoMapper.alumnoEntityToAlumnoModel(alumnoEntity);
            return Optional.of(alumnoModel);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Alumno> updateAlumno(int idAlumno, Alumno alumnoActualizado) {
        com.fcm.backend.repository.entity.Alumno alumnoEntity = AlumnoMapper.alumnoModelToAlumnoEntity(alumnoActualizado);
        com.fcm.backend.repository.entity.Alumno updatedEntity = alumnoRepository.updateAlumno(Long.valueOf(idAlumno), alumnoEntity);

        if (updatedEntity != null) {
            Alumno updatedModel = AlumnoMapper.alumnoEntityToAlumnoModel(updatedEntity);
            return Optional.of(updatedModel);
        }
        return Optional.empty();
    }
    @Override
    public boolean deleteAlumno(int idAlumno) {
        com.fcm.backend.repository.entity.Alumno existingAlumno = alumnoRepository.getAlumnoById(Long.valueOf(idAlumno));
        if (existingAlumno == null) {
            return false;
        } else {
            alumnoRepository.deleteAlumno(Long.valueOf(idAlumno));
            return true;
        }
    }

}