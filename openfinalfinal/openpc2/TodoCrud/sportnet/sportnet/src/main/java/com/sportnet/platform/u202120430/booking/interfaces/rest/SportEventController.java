package com.sportnet.platform.u202120430.booking.interfaces.rest;

import com.sportnet.platform.u202120430.booking.domain.model.aggregates.SportEvent;
import com.sportnet.platform.u202120430.booking.domain.model.commands.DeleteSportEventCommand;
import com.sportnet.platform.u202120430.booking.domain.model.queries.GetAllSportEventsQuery;
import com.sportnet.platform.u202120430.booking.domain.model.queries.GetSportEventByIdQuery;
import com.sportnet.platform.u202120430.booking.domain.services.SportEventCommandService;
import com.sportnet.platform.u202120430.booking.domain.services.SportEventQueryService;
import com.sportnet.platform.u202120430.booking.interfaces.rest.resources.CreateSportEventResource;
import com.sportnet.platform.u202120430.booking.interfaces.rest.resources.SportEventResource;
import com.sportnet.platform.u202120430.booking.interfaces.rest.resources.UpdateSportEventResource;
import com.sportnet.platform.u202120430.booking.interfaces.rest.transform.CreateSportEventCommandFromResourceAssembler;
import com.sportnet.platform.u202120430.booking.interfaces.rest.transform.SportEventResourceFromEntityAssembler;
import com.sportnet.platform.u202120430.booking.interfaces.rest.transform.UpdateSportEventCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/v1/sport-events", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Sport Events", description = "Sport Events Management Endpoints")
public class SportEventController {
    private final SportEventCommandService sportEventCommandService;
    private final SportEventQueryService sportEventQueryService;

    public SportEventController(SportEventCommandService sportEventCommandService, SportEventQueryService sportEventQueryService) {
        this.sportEventCommandService = sportEventCommandService;
        this.sportEventQueryService = sportEventQueryService;
    }

    //POST method to create a new sport event
    @PostMapping
    public ResponseEntity<SportEventResource> createSportEvent(@RequestBody CreateSportEventResource res) {
        var createSportEventCommand = CreateSportEventCommandFromResourceAssembler.toCommandFromResource(res);
        var sportEventId = sportEventCommandService.handle(createSportEventCommand);
        if (sportEventId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getSportEventByIdQuery = new GetSportEventByIdQuery(sportEventId);
        var sportEvent = sportEventQueryService.handle(getSportEventByIdQuery);
        if (sportEvent.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var sportEventResource = SportEventResourceFromEntityAssembler.toResourceFromEntity(sportEvent.get());
        return new ResponseEntity<>(sportEventResource, HttpStatus.CREATED);
    }

    //GET method to get all sport events
    @GetMapping
    public ResponseEntity<List<SportEventResource>> getAllSportEvents() {
        var getAllSportEventsQuery = new GetAllSportEventsQuery();
        var sportEvents = sportEventQueryService.handle(getAllSportEventsQuery);
        var sportEventResources = sportEvents.stream().map(SportEventResourceFromEntityAssembler::toResourceFromEntity).toList();
        return new ResponseEntity<>(sportEventResources, HttpStatus.OK);
    }

    //GET method to get a sport event by id
    @GetMapping("/{sportEventId}")
    public ResponseEntity<SportEventResource> getSportEventById(@PathVariable Long sportEventId) {
        var getSportEventByIdQuery = new GetSportEventByIdQuery(sportEventId);
        var sportEvent = sportEventQueryService.handle(getSportEventByIdQuery);
        if (sportEvent.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var sportEventResource = SportEventResourceFromEntityAssembler.toResourceFromEntity(sportEvent.get());
        return new ResponseEntity<>(sportEventResource, HttpStatus.OK);
    }

    //PUT method to update a sport event
    @PutMapping("/{sportEventId}")
    public ResponseEntity<SportEventResource> updateSportEvent(@PathVariable Long sportEventId, @RequestBody UpdateSportEventResource res) {
        var updateSportEventCommand = UpdateSportEventCommandFromResourceAssembler.toCommandFromResource(sportEventId, res);
        var updateSportEvent = sportEventCommandService.handle(updateSportEventCommand);
        if (updateSportEvent.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var sportEvent = SportEventResourceFromEntityAssembler.toResourceFromEntity(updateSportEvent.get());
        return ResponseEntity.ok(sportEvent);
    }

    //DELETE method to delete a sport event
    @DeleteMapping("/{sportEventId}")
    public ResponseEntity<?> deleteSportEvent(@PathVariable Long sportEventId) {
        var deleteSportEventCommand = new DeleteSportEventCommand(sportEventId);
        var sportEventDeleted = sportEventCommandService.handle(deleteSportEventCommand);
        if (sportEventDeleted.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Resource deleted successfully");
    }

}
