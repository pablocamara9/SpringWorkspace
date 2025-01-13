package com.salesianostriana.data;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProductoRepository repo;

    @PostConstruct
    public void run() {
        Producto p = Producto.builder()
                .nombre("Un producto")
                .precioVenta(123.45)
                .descripcion("Se trata de un producto de nuestro catálogo.")
                .build();

        repo.save(p);

        Producto p2 = Producto.builder()
                .nombre("Otro producto")
                .precioVenta(999.99)
                .descripcion("Se trata de otro producto de nuestro catálogo, bastante más caro.")
                .build();

        repo.save(p2);
    }

}
