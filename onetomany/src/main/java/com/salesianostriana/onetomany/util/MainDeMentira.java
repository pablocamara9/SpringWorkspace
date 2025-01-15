package com.salesianostriana.onetomany.util;

import com.salesianostriana.onetomany.model.Biblioteca;
import com.salesianostriana.onetomany.model.Libro;
import com.salesianostriana.onetomany.repo.BibliotecaRepo;
import com.salesianostriana.onetomany.repo.LibroRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final LibroRepo libroRepo;
    private final BibliotecaRepo bibliotecaRepo;

    @PostConstruct
    public void init() {

        Biblioteca b = Biblioteca.builder()
                .nombre("Biblioteca Salesianos Triana")
                .direccion("Condes de Bustillo S/N")
                .telefono("954123321")
                .build();

        Libro l1 = Libro.builder()
                .titulo("Java para novatos")
                .autor("Los hermanos Déitel")
                .build();

        Libro l2 = Libro.builder()
                .titulo("Fuerza para vivir")
                .autor("Donato Gama da Silva")
                .build();

        Libro l3 = Libro.builder()
                .titulo("Como tener el pelo más fuerte")
                .autor("Carlos Ruiz López")
                .build();

        b.addLibro(l1);
        b.addLibro(l2);
        b.addLibro(l3);

        libroRepo.save(l1);
        libroRepo.save(l2);
        libroRepo.save(l3);

        bibliotecaRepo.save(b);
    }
}
