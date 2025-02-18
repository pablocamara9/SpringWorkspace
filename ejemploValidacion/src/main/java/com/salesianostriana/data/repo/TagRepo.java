package com.salesianostriana.data.repo;

import com.salesianostriana.data.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepo
        extends JpaRepository<Tag, Long> {
}
