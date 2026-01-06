package io.travelers.platform.profiles.infrastructure.persistence.jpa.repositories;

import io.travelers.platform.profiles.domain.model.entities.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Long>{
    boolean existsByName(String name);
}
