package com.salesianostriana.data.service;

import com.salesianostriana.data.dto.EditProductoDto;
import com.salesianostriana.data.model.Producto;
import com.salesianostriana.data.repo.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    public List<Producto> findAll() {
        List<Producto> result = productoRepository.findAll();

        if (result.isEmpty())
            throw new EntityNotFoundException("No hay productos.");
        return result;
    }

    public Producto findById(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay producto con id " + id));
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto edit(EditProductoDto editProductoDto, Long id) {
        return productoRepository.findById(id)
                .map(old -> {
                    old.setNombre(editProductoDto.nombre());
                    old.setDescripcion(editProductoDto.descripcion());
                    old.setPrecioVenta(editProductoDto.precio());
                    return productoRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay producto con id " + id));
    }

    public void delete(Long id) {
        productoRepository.deleteById(id);
    }
}
