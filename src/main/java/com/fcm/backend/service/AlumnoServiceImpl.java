package com.fcm.backend.service;

import com.fcm.backend.model.Alumno;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    private List<Alumno> alumnoList = new ArrayList<>();

    @Override
    public List<Alumno> getAlumnoList(){
        return alumnoList;
    }

    @Override
    public void createAlumno(Alumno newAlumno) {
        alumnoList.add(newAlumno);
    }

    @Override
    public Alumno getAlumnoById(int id){
        return alumnoList.get(id);
    }

    @Override
    public Optional<Alumno> updateAlumno(int id, Alumno updatedAlumno) {
        if (id >= 0 && id < alumnoList.size()) {
            Alumno existingAlumno = alumnoList.get(id);
            existingAlumno.setNombre(updatedAlumno.getNombre());
            existingAlumno.setApellidoPat(updatedAlumno.getApellidoPat());
            existingAlumno.setApellidoMat(updatedAlumno.getApellidoMat());
            existingAlumno.setTelefono(updatedAlumno.getTelefono());
            existingAlumno.setEmail(updatedAlumno.getEmail());

            return Optional.of(existingAlumno);
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteAlumno(int id) {
        if (id >= 0 && id < alumnoList.size()) {
            alumnoList.remove(id);
            return true;
        }
        return false;
    }
}