package io.travelers.platform.profiles.infrastructure.persistence.jpa.repositories;

import io.travelers.platform.profiles.domain.model.aggregates.Agency;
import io.travelers.platform.profiles.domain.model.entities.Business;
import io.travelers.platform.profiles.domain.model.valueobjects.AgencyName;
import io.travelers.platform.profiles.domain.model.valueobjects.Geolocation;
import io.travelers.platform.profiles.domain.model.valueobjects.StreetAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {
    Optional<Agency> findByBusinessIdAndName(Business business, AgencyName name);
    Optional<Agency> findByGeolocation(Geolocation geolocation);
    Optional<Agency> findByAddress(StreetAddress address);
}
