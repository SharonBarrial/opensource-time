package com.sportnet.platform.u202120430.booking.domain.model.aggregates;

import com.sportnet.platform.u202120430.booking.domain.model.commands.CreateSportEventCommand;
import com.sportnet.platform.u202120430.booking.domain.model.valueobjects.*;
import com.sportnet.platform.u202120430.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.util.Strings;

import java.awt.datatransfer.StringSelection;

/**
 * Sport event aggregate root
 */

@Getter
@Setter
@Entity
public class SportEvent extends AuditableAbstractAggregateRoot<SportEvent> {
    @Embedded
    private EventName eventName;
    @Embedded
    private SportType sportType;
    @Embedded
    private Location location;
    @Embedded
    private Capacity capacity;
    @Embedded
    private OrganizerId organizerId;

    /**
     * Default constructor
     */
    public SportEvent() {}

    /**
     * Constructor
     * @param eventName
     * @param sportType
     * @param location
     * @param capacity
     * @param organizerId
     */
    public SportEvent(EventName eventName, SportType sportType, Location location, Capacity capacity, OrganizerId organizerId) {
        this();
        this.eventName = eventName;
        this.sportType = sportType;
        this.location = location;
        this.capacity = capacity;
        this.organizerId = organizerId;
    }

    /**
     * Constructor
     * @param command
     */
    public SportEvent(CreateSportEventCommand command) {
        this();
        this.eventName = new EventName(command.eventName());
        this.sportType = new SportType(command.sportType());
        this.location = new Location(command.location());
        this.capacity = new Capacity(command.capacity());
        this.organizerId = new OrganizerId(command.organizerId());
    }

    //Getters
    public String getEventName() {
        return eventName.eventName();
    }
    public String getSportType() {
        return sportType.sportType();
    }
    public String getLocation() {
        return location.location();
    }
    public int getCapacity() {
        return capacity.capacity();
    }
    public long getOrganizerId() {
        return organizerId.organizerId();
    }

}
