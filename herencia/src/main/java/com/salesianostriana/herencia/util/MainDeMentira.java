package com.salesianostriana.herencia.util;

import com.salesianostriana.herencia.model.Alumno;
import com.salesianostriana.herencia.model.Persona;
import com.salesianostriana.herencia.repo.AlumnoRepo;
import com.salesianostriana.herencia.repo.PersonaRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final PersonaRepo personaRepo;
    private final AlumnoRepo alumnoRepo;

    @PostConstruct
    public void init() {

        // ALUMNO (PERSONA)
        Alumno a1 = Alumno.builder()
                .dni("12345678A")
                .nombre("Paco")
                .apellidos("Cruz")
                .edad(21)
                .notaMedia(8.75)
                .build();

        Alumno a2 = Alumno.builder()
                .dni("87654321A")
                .nombre("Jose")
                .apellidos("Sánchez")
                .edad(34)
                .notaMedia(6.2)
                .build();

        alumnoRepo.save(a1);
        alumnoRepo.save(a2);

        //

    }
}
