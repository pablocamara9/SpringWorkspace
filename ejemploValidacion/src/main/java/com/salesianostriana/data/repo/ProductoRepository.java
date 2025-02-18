package com.salesianostriana.data.repo;

import com.salesianostriana.data.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository
        extends JpaRepository<Producto, Long> {
}
