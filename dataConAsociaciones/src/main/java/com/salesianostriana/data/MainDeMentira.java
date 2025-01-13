package com.salesianostriana.data;

import com.salesianostriana.data.model.Categoria;
import com.salesianostriana.data.model.Producto;
import com.salesianostriana.data.repo.CategoriaRepository;
import com.salesianostriana.data.repo.ProductoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProductoRepository repo;
    private final CategoriaRepository categoriaRepository;

    @PostConstruct
    public void run() {
        Categoria c = categoriaRepository.getReferenceById(1L);

        Producto p = Producto.builder()
                .nombre("Un producto")
                .precioVenta(123.45)
                .descripcion("Se trata de un producto de nuestro catálogo.")
                .categoria(c)
                .build();

        repo.save(p);

        Producto p2 = Producto.builder()
                .nombre("Otro producto")
                .precioVenta(999.99)
                .descripcion("Se trata de otro producto de nuestro catálogo, bastante más caro.")
                .categoria(c)
                .build();

        repo.save(p2);
    }

}
