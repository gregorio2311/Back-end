package com.fcm.backend.repository;

import com.fcm.backend.repository.entity.Alumno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlumnoRepositoryImpl implements AlumnoRepository{
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void insertar(Alumno alumno) {
        em.persist(alumno);
    }

    @Override
    public Alumno getAlumnoById(Long id){
        return em.find(Alumno.class, id);
    }
    List<com.fcm.backend.model.Alumno> alumnoList = new ArrayList<>();

    @Override
    public List<Alumno> getAlumnoList() {
        TypedQuery<Alumno> query = em.createQuery("SELECT a FROM Alumno a", Alumno.class);
        return query.getResultList();
    }
    @Transactional
    public Alumno updateAlumno(Long id, Alumno alumnoActualizado) {
        Alumno alumnoToUpdate = em.find(Alumno.class, id);
        if (alumnoToUpdate != null) {
            alumnoToUpdate.setPrimerNombre(alumnoActualizado.getPrimerNombre());
            alumnoToUpdate.setSegundoNombre(alumnoActualizado.getSegundoNombre());
            alumnoToUpdate.setApellidoPat(alumnoActualizado.getApellidoPat());
            alumnoToUpdate.setApellidoMat(alumnoActualizado.getApellidoMat());
            alumnoToUpdate.setFechaNac(alumnoActualizado.getFechaNac());
            alumnoToUpdate.setCurp(alumnoActualizado.getCurp());
            alumnoToUpdate.setEmail(alumnoActualizado.getEmail());
            return em.merge(alumnoToUpdate);
        }
        return null;
    }

    @Transactional
    public void deleteAlumno(Long id) {
        Alumno alumnoToDelete = em.find(Alumno.class, id);
        if (alumnoToDelete != null) {
            em.remove(alumnoToDelete);
            em.flush();
        }
    }


}
