package com.acme.catchup.platform.news.infrastructure.persistance.jpa;

import com.acme.catchup.platform.news.domain.model.aggregates.FavoriteSource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing FavoriteSource entities.
 *
 * <p>This repository provides methods to perform CRUD operations on FavoriteSource entities, as well as custom queries
 * to find favorite sources by their news API key and source ID.</p>
 */
public interface FavoriteSourceRepository extends JpaRepository<FavoriteSource, Long> {

    /**
     * Finds all FavoriteSource entities by the specified news API key.
     *
     * @param newsApiKey the news API key
     * @return a list of FavoriteSource entities matching the specified news API key
     */
    List<FavoriteSource> findAllByNewsApiKey(String newsApiKey);

    /**
     * Checks if a FavoriteSource entity exists by the specified news API key and source ID.
     *
     * @param newsApiKey the news API key
     * @param sourceId the source ID
     * @return true if a FavoriteSource entity exists with the specified news API key and source ID, false otherwise
     */
    boolean existsByNewsApiKeyAndSourceId(String newsApiKey, String sourceId);

    /**
     * Finds a FavoriteSource entity by the specified news API key and source ID.
     *
     * @param newsApiKey the news API key
     * @param sourceId the source ID
     * @return an Optional containing the FavoriteSource entity if found, or empty if not found
     */
    Optional<FavoriteSource> findByNewsApiKeyAndSourceId(String newsApiKey, String sourceId);
}

