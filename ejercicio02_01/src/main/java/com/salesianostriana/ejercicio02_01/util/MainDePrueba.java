package com.salesianostriana.ejercicio02_01.util;

import com.salesianostriana.ejercicio02_01.model.Categoria;
import com.salesianostriana.ejercicio02_01.model.Producto;
import com.salesianostriana.ejercicio02_01.repo.CategoriaRepo;
import com.salesianostriana.ejercicio02_01.repo.ProductoRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDePrueba {

    private final ProductoRepo productoRepo;
    private final CategoriaRepo categoriaRepo;

    @PostConstruct
    public void init() {
        Categoria c1 = Categoria.builder()
                .nombre("Fruta")
                .build();

        Categoria c2 = Categoria.builder()
                .nombre("Lácteos")
                .build();

        Producto p1 = Producto.builder()
                .nombre("Queso de oveja")
                .pvp(2.99)
                .build();

        Producto p2 = Producto.builder()
                .nombre("Yougur de fresa")
                .pvp(3.50)
                .build();

        Producto p3 = Producto.builder()
                .nombre("Racimo de uvas")
                .pvp(1.30)
                .build();

        Producto p4 = Producto.builder()
                .nombre("Plátano de Canarias")
                .pvp(0.99)
                .build();

        p1.setCategoria(c2);
        p2.setCategoria(c2);
        p3.setCategoria(c1);
        p4.setCategoria(c1);

        categoriaRepo.save(c1);
        categoriaRepo.save(c2);

        productoRepo.save(p1);
        productoRepo.save(p2);
        productoRepo.save(p3);
        productoRepo.save(p4);

    }
}

