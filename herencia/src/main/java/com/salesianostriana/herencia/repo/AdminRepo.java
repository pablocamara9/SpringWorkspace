package com.salesianostriana.herencia.repo;

import com.salesianostriana.herencia.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo
        extends JpaRepository<Admin, Long> {
}
