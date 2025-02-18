package com.salesianostriana.data.controller;

import com.salesianostriana.data.dto.GetCategoriaDto;
import com.salesianostriana.data.model.Categoria;
import com.salesianostriana.data.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria/")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> findAll() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public Categoria findById(@PathVariable Long id) {
        return categoriaService.findById(id);

    }

    @PostMapping
    public ResponseEntity<Categoria> add(@RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        categoriaService.save(categoria));
    }

    @PutMapping("/{id}")
    public Categoria edit(@RequestBody Categoria categoria, @PathVariable Long id) {
        return categoriaService.edit(categoria, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
