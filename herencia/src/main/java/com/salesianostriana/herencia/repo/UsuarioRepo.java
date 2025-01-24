package com.salesianostriana.herencia.repo;

import com.salesianostriana.herencia.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo
        extends JpaRepository<Usuario, Long> {
}
