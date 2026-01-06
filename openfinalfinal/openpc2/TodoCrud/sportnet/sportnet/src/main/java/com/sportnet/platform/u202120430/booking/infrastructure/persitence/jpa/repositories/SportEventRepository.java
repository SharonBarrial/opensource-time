package com.sportnet.platform.u202120430.booking.infrastructure.persitence.jpa.repositories;

import com.sportnet.platform.u202120430.booking.domain.model.aggregates.SportEvent;
import com.sportnet.platform.u202120430.booking.domain.model.valueobjects.EventName;
import com.sportnet.platform.u202120430.booking.domain.model.valueobjects.Location;
import com.sportnet.platform.u202120430.booking.domain.model.valueobjects.OrganizerId;
import com.sportnet.platform.u202120430.booking.domain.model.valueobjects.SportType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * JPA Repository for SportEvent entity.
 */
@Repository
public interface SportEventRepository extends JpaRepository<SportEvent, Long> {
    boolean existsByEventNameAndSportTypeAndLocation(EventName eventName, SportType sportType, Location location);
    boolean existsByOrganizerId(OrganizerId organizerId);
}
