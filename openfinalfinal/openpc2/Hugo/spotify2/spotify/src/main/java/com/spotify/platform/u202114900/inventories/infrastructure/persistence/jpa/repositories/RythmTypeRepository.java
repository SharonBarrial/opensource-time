package com.spotify.platform.u202114900.inventories.infrastructure.persistence.jpa.repositories;

import com.spotify.platform.u202114900.inventories.domain.models.entities.RythmType;
import com.spotify.platform.u202114900.inventories.domain.models.valueobjects.RythmTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RythmTypeRepository extends JpaRepository<RythmType, Long>{

    boolean existsByName(RythmTypes name);
}
