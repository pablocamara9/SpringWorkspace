package com.salesianostriana.ejercicio02_01.service;

import com.salesianostriana.ejercicio02_01.model.Producto;
import com.salesianostriana.ejercicio02_01.repo.ProductoRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepo productoRepo;

    public List<Producto> findAll() {
        List<Producto> result = productoRepo.findAll();

        if (result.isEmpty()) {
            throw new EntityNotFoundException("No hay productos en el listado");
        }
        return result;
    }

    public Producto findById(Long id) {
        return productoRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay productos con el id " + id));
    }

    public Producto save(Producto p) {
        return productoRepo.save(p);
    }

    public Producto edit(Producto p, Long id) {
        return productoRepo.findById(id)
                .map(old -> {
                    old.setNombre(p.getNombre());
                    old.setPvp(p.getPvp());
                    return productoRepo.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay productos con el id " + id));
    }

    public void delete(Long id) {
        productoRepo.deleteById(id);
    }
}
