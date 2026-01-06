package com.spotify.platform.u202317002.inventories.infrastructure.persistence.jpa.repositories;

import com.spotify.platform.u202317002.inventories.domain.models.agreggates.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    boolean existsByNameAndSingerAndGroupAndRhythm_Id(String name, String singer, String group, Long rhythmId);
}