package com.salesianostriana.herencia.util;

import com.salesianostriana.herencia.model.*;
import com.salesianostriana.herencia.repo.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final PersonaRepo personaRepo;
    private final AlumnoRepo alumnoRepo;
    private final UsuarioRepo usuarioRepo;
    private final AdminRepo adminRepo;
    private final ClienteRepo clienteRepo;

    @PostConstruct
    public void init() {

        // JOINED (ALUMNO - PERSONA)
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

        // SINGLE TABLE (USUARIO - ADMIN Y CLIENTE)
        Admin admin = Admin.builder()
                .nombre("Admin")
                .username("admin")
                .password("admin")
                .build();

        Cliente c1 = Cliente.builder()
                .nombre("Jose Rafael Alexander")
                .username("joserafalex")
                .password("1234")
                .build();

        Cliente c2 = Cliente.builder()
                .nombre("Carlos Pérez")
                .password("4321")
                .build();

        adminRepo.save(admin);
        clienteRepo.save(c1);
        clienteRepo.save(c2);

    }
}
