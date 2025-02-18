package com.salesianostriana.data.controller;

import com.salesianostriana.data.dto.EditProductoDto;
import com.salesianostriana.data.dto.GetProductoDto;
import com.salesianostriana.data.service.ProductoService;
import com.salesianostriana.data.model.Producto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public List<GetProductoDto> getAll() {
        return productoService.findAll()
                .stream()
                .map(GetProductoDto::of)
                .toList();
    }

    @GetMapping("/{id}")
    public Producto getById(Long id) {
        return productoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto nuevo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        productoService.save(nuevo));
    }

    @PutMapping("/{id}")
    public Producto update(@RequestBody @Valid EditProductoDto aEditar, @PathVariable Long id) {
        return productoService.edit(aEditar, id);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
