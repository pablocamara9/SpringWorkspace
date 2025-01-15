package com.salesianostriana.onetomany.repo;

import com.salesianostriana.onetomany.model.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecaRepo
        extends JpaRepository<Biblioteca, Long> {
}
