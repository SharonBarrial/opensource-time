package com.sportnet.platform.u202212721.booking.interfaces.rest;

import com.sportnet.platform.u202212721.booking.domain.services.SportEventCommandService;
import com.sportnet.platform.u202212721.booking.interfaces.rest.resources.CreateSportEventResource;
import com.sportnet.platform.u202212721.booking.interfaces.rest.transform.CreateSportEventCommandFromResourceAssembler;
import com.sportnet.platform.u202212721.booking.interfaces.rest.transform.SportEventResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sport Event Controller
 *  <p>
 *      This class is responsible for handling the REST API requests related to the sport events.
 *      It is responsible for creating sport events.
 *  </p>
 * @author  U202212721 Mathias Jave Diaz
 * @version  1.0
 */
@RestController
@RequestMapping(value = "/api/v1/sport-events", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Sport Event", description = "Sport Event Controller")
public class SportEventController {

    private final SportEventCommandService sportEventCommandService;

    public SportEventController(SportEventCommandService sportEventCommandService) {
        this.sportEventCommandService = sportEventCommandService;
    }

    @PostMapping
    public ResponseEntity<?> createSportEvent(@RequestBody CreateSportEventResource resource){
        var command = CreateSportEventCommandFromResourceAssembler.toCommandFromResource(resource);
        var sportEvent = sportEventCommandService.handle(command);
        var sportEventResource = SportEventResourceFromEntityAssembler.toResourceFromEntity(sportEvent.get());
        return new ResponseEntity<>(sportEventResource, HttpStatus.CREATED);
    }

}
