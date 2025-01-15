package com.salesianostriana.onetomany.repo;

import com.salesianostriana.onetomany.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepo
        extends JpaRepository<Libro, Long> {
}
