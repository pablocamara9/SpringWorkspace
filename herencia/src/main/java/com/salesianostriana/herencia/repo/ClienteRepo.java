package com.salesianostriana.herencia.repo;

import com.salesianostriana.herencia.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepo
        extends JpaRepository<Cliente, Long> {
}
