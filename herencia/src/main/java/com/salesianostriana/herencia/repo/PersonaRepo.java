package com.salesianostriana.herencia.repo;

import com.salesianostriana.herencia.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepo
        extends JpaRepository<Persona, Long> {
}
