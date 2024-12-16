package com.example.monumentos;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/monumento")
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumentoRepository monumentoRepository;

    @GetMapping
    public ResponseEntity<List<Monumento>> getAll(
            @RequestParam(required = false, value = "nombreCiudad", defaultValue = "all") String ciudad,
            @RequestParam(required = false, value = "sort", defaultValue = "desc") String sortDirection
    ) {
        List<Monumento> result = monumentoRepository.orderByName(ciudad, sortDirection);

        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Monumento> add(@RequestBody Monumento monumento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(monumentoRepository.add(monumento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monumento> getById(@PathVariable Long id) {
        return ResponseEntity.of(monumentoRepository.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monumento> edit(@RequestBody Monumento monumento, @PathVariable("id") Long idMonumento) {
        return ResponseEntity.of(monumentoRepository.edit(idMonumento, monumento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Monumento> delete(@PathVariable Long idMonumento) {
        monumentoRepository.delete(idMonumento);
        return ResponseEntity.noContent().build();
    }









}
