package com.salesianostriana.data.service;

import com.salesianostriana.data.model.Categoria;
import com.salesianostriana.data.repo.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        List<Categoria> result = categoriaRepository.findAll();

        if (result.isEmpty())
            throw new EntityNotFoundException("No se encontraron categorías.");
        return result;
    }

    public Categoria findById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la categoría con el id: " + id));
    }

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria edit(Categoria c, Long id) {
        return categoriaRepository.findById(id)
                .map(old ->{
                    old.setNombre(c.getNombre());
                    return categoriaRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No se ha encontrado la categoría con el id " + id));
    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }
}
