package com.salesianostriana.herencia.util;

import com.salesianostriana.herencia.model.Alumno;
import com.salesianostriana.herencia.model.Persona;
import com.salesianostriana.herencia.repo.PersonaRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final PersonaRepo personaRepo;

    @PostConstruct
    public void init() {

        Persona p1 = Persona.builder()
                .dni("12345678A")
                .nombre("Paco")
                .apellidos("Cruz")
                .build();

        Persona p2 = Persona.builder()
                .dni("87654321A")
                .nombre("Jose")
                .apellidos("Sanchez")
                .build();

        personaRepo.save(p1);
        personaRepo.save(p2);
    }
}
