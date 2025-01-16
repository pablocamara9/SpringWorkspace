package com.salesianostriana.ejercicio02_01.repo;

import com.salesianostriana.ejercicio02_01.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepo
        extends JpaRepository<Producto, Long> {
}
