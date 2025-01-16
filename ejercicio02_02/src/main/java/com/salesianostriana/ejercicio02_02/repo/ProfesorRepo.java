package com.salesianostriana.ejercicio02_02.repo;

import com.salesianostriana.ejercicio02_02.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepo
        extends JpaRepository<Profesor, Long> {
}
