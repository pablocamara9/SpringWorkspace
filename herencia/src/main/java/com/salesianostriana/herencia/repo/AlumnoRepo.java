package com.salesianostriana.herencia.repo;

import com.salesianostriana.herencia.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepo
        extends JpaRepository<Alumno, Long> {
}
