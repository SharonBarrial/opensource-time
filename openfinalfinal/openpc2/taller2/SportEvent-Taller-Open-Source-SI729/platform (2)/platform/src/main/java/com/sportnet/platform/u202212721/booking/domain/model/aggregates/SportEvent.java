package com.sportnet.platform.u202212721.booking.domain.model.aggregates;

import com.sportnet.platform.u202212721.booking.domain.model.commands.CreateSportEventCommand;
import com.sportnet.platform.u202212721.booking.domain.model.valueobjects.OrganizerId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

/**
 * SportEvent aggregate root
 * <p>
 *     This class represents the SportEvent aggregate root. It contains the attributes of a sport event.
 * </p>
 * @author  U202212721 Mathias Alejandro Jave Diaz
 * @version  1.0
 */
@Entity
@Getter
public class SportEvent  {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String eventName;

    @Embedded
    @Column(nullable = false, name = "organizer_id")
    private final OrganizerId organizerId;

    @NotBlank
    @Column(nullable = false)
    private String sportType;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Integer capacity;

    /**
     * Constructor for the SportEvent with command parameter
     * <p>
     *     This constructor creates a SportEvent object with the attributes of a sport event.
     * </p>
     * @param command
     * @author  U202212721 Mathias Jave Diaz
     */

    public SportEvent(CreateSportEventCommand command ){
        this.eventName = command.eventName();
        this.organizerId = new OrganizerId(command.organizerId());
        this.sportType = command.sportType();
        this.location = command.location();
        this.capacity = command.capacity();

    }

    public SportEvent(){
        this.location = Strings.EMPTY;
        this.eventName = Strings.EMPTY;
        this.sportType = Strings.EMPTY;
        this.capacity = 0;
        this.organizerId = null;
    }

    public SportEvent(OrganizerId organizerId) {

        this.organizerId = organizerId;
    }

}
