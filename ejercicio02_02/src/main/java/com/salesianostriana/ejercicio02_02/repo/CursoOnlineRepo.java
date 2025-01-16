package com.salesianostriana.ejercicio02_02.repo;

import com.salesianostriana.ejercicio02_02.model.CursoOnline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoOnlineRepo
        extends JpaRepository<CursoOnline, Long> {
}
