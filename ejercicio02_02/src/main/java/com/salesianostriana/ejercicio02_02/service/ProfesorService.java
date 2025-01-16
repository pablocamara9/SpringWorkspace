package com.salesianostriana.ejercicio02_02.service;

import com.salesianostriana.ejercicio02_02.model.Profesor;
import com.salesianostriana.ejercicio02_02.repo.ProfesorRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfesorService {

    private final ProfesorRepo profesorRepo;

    public List<Profesor> findAll() {
        List<Profesor> result = profesorRepo.findAll();

        if (result.isEmpty()) {
            throw new EntityNotFoundException("No hay profesores en el listado");
        }
        return result;
    }

    public Profesor findById(Long id) {
        return profesorRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay profesores con el id " + id));
    }

    public Profesor save(Profesor p) {
        return profesorRepo.save(p);
    }

    public Profesor edit(Profesor p, Long id) {
        return profesorRepo.findById(id)
                .map(old -> {
                    old.setNombre(p.getNombre());
                    old.setEmail(p.getEmail());
                    old.setPuntuacion(p.getPuntuacion());
                    return profesorRepo.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay profesores con el id " + id));
    }

    public void delete(Long id) {
        profesorRepo.deleteById(id);
    }
}
