package com.salesianostriana.ejercicio02_01.service;

import com.salesianostriana.ejercicio02_01.model.Categoria;
import com.salesianostriana.ejercicio02_01.repo.CategoriaRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepo categoriaRepo;

    public List<Categoria> findAll() {
        List<Categoria> result = categoriaRepo.findAll();

        if(result.isEmpty()) {
            throw new EntityNotFoundException("No se han encontrado categorías");
        }
        return result;
    }

    public Categoria findById(Long id) {
        return categoriaRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se han encontrado categorías con el id " + id));
    }

    public Categoria save(Categoria c) {
        return categoriaRepo.save(c);
    }

    public Categoria edit(Categoria c, Long id) {
        return categoriaRepo.findById(id)
                .map(old -> {
                    old.setNombre(c.getNombre());
                    return categoriaRepo.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No se han encontrado categorías con el id " + id));
    }

    public void delete(Long id) {
        categoriaRepo.deleteById(id);
    }
}
