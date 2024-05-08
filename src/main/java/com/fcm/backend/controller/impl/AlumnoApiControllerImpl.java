package com.fcm.backend.controller.impl;

import com.fcm.backend.controller.AlumnoApiController;
import com.fcm.backend.model.Alumno;
import com.fcm.backend.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class AlumnoApiControllerImpl implements AlumnoApiController {
    private final AlumnoService alumnoService;

    @Autowired
    AlumnoApiControllerImpl(AlumnoService alumnoService){
        this.alumnoService = alumnoService;
    }

    @Override
    public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumnoNuevo){
        alumnoService.createAlumno(alumnoNuevo);
        return ResponseEntity.ok().body(alumnoNuevo);
    }

    @Override
    public ResponseEntity<List<Alumno>> getAlumnoList() {
        return ResponseEntity.ok().body(alumnoService.getAlumnoList());
    }

    @Override
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable int idAlumno){
        return ResponseEntity.ok().body(alumnoService.getAlumnoById(idAlumno));
    }

    @Override
    public ResponseEntity<?> updateAlumno(@PathVariable int idAlumno, @RequestBody Alumno alumnoActualizado) {
        Optional<Alumno> alumno = alumnoService.updateAlumno(idAlumno, alumnoActualizado);
        return alumno.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> deleteAlumno(@PathVariable int idAlumno) {
        boolean deleted = alumnoService.deleteAlumno(idAlumno);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}