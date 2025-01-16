package com.salesianostriana.ejercicio02_02.repo;

import com.salesianostriana.ejercicio02_02.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepo
        extends JpaRepository<Video, Long> {
}
