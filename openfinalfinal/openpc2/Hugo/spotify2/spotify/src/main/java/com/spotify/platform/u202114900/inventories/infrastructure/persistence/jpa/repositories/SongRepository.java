package com.spotify.platform.u202114900.inventories.infrastructure.persistence.jpa.repositories;

import com.spotify.platform.u202114900.inventories.domain.models.aggregates.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    boolean existsByNameAndSingerAndGroupNameAndRythmId(String name, String singer, String groupName, Long rythmId);
}
