package com.sportnet.platform.u202212721.booking.infrastructure.persitence.jpa.repositories;

import com.sportnet.platform.u202212721.booking.domain.model.aggregates.SportEvent;
import com.sportnet.platform.u202212721.booking.domain.model.valueobjects.OrganizerId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for SportEvent entity
 *  <p>
 *      This interface extends JpaRepository to provide basic CRUD operations for SportEvent entity
 *      and queries that are not provided by JpaRepository can be defined here.
 *  </p>
 * @author U202212721
 *
 */
public interface SportEventRepository extends JpaRepository<SportEvent, Long>{

     boolean existsByEventNameAndSportTypeAndLocation (String eventName, String sportType, String location);

     boolean existsByOrganizerId (OrganizerId organizerId);

}
