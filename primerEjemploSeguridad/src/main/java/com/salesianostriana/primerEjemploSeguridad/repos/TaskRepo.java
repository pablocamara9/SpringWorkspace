package com.salesianostriana.primerEjemploSeguridad.repos;

import com.salesianostriana.primerEjemploSeguridad.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo
        extends JpaRepository<Task, Long> {
}
