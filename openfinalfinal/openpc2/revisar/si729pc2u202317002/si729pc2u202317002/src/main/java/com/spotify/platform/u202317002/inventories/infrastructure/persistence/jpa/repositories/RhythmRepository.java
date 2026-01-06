package com.spotify.platform.u202317002.inventories.infrastructure.persistence.jpa.repositories;

import com.spotify.platform.u202317002.inventories.domain.models.entities.Rhythm;
import com.spotify.platform.u202317002.inventories.domain.models.valueobjets.Rhythms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RhythmRepository extends JpaRepository<Rhythm, Long> {
    boolean existsByName(Rhythms name);
}