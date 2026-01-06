package com.library.platform.upc.Inventario.infrastructure.persistence.jpa;

import com.library.platform.upc.Inventario.domain.model.entities.Genre;
import com.library.platform.upc.Inventario.domain.model.valueobjects.Genres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    Optional<Genre> findByName(Genres name);
    boolean existsByName(Genres name);
}
