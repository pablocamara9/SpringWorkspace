package com.salesianostriana.ejercicio02_01.repo;

import com.salesianostriana.ejercicio02_01.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepo
        extends JpaRepository<Categoria, Long> {
}
