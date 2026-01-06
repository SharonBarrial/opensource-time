package io.travelers.platform.profiles.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.travelers.platform.profiles.domain.model.queries.GetAllAgenciesQuery;
import io.travelers.platform.profiles.domain.services.AgencyCommandService;
import io.travelers.platform.profiles.domain.services.AgencyQueryService;
import io.travelers.platform.profiles.interfaces.rest.resources.AgencyResource;
import io.travelers.platform.profiles.interfaces.rest.resources.CreateAgencyResource;
import io.travelers.platform.profiles.interfaces.rest.transform.AgencyResourceFromEntityAssembler;
import io.travelers.platform.profiles.interfaces.rest.transform.CreateAgencyCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * AgenciesController
 * <p>
 *     This class is the entry point for all the REST endpoints related to the Agency entity.
 * </p>
 * @author Nombre y Apellido
 */
@RestController
@RequestMapping(value="/api/v1/agencies", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Agencies", description="Agencies Management Endpoints")
public class AgenciesController {

    private final AgencyQueryService agencyQueryService;
    private final AgencyCommandService agencyCommandService;

    public AgenciesController(AgencyQueryService agencyQueryService, AgencyCommandService agencyCommandService){
        this.agencyQueryService = agencyQueryService;
        this.agencyCommandService = agencyCommandService;
    }

    /**
     * Create a new Agency
     * @param resource the resource containing the data to create the Agency
     * @return the created Agency
     */
    @Operation(summary="Create a new Agency", description="Create a new Agency with the input data.")
    @PostMapping
    public ResponseEntity<AgencyResource> createAgency(@RequestBody CreateAgencyResource resource){
        try{
            var createAgencyCommand = CreateAgencyCommandFromResourceAssembler.toCommandFromResource(resource);
            var agency = agencyCommandService.handle(createAgencyCommand);
            var agencyResource = AgencyResourceFromEntityAssembler.toResourceFromEntity(agency.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(agencyResource); //201
        }catch (IllegalArgumentException e){ //404
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
        }
    }

    /**
     * Get all agencies
     * @return a list of all the Agency resources currently stored
     */
    @Operation(summary="Get all agencies", description="Retrieves a List of all agencies in the database.") //Open API documentation
    @GetMapping
    public ResponseEntity<List<AgencyResource>> getAllAgencies(){
        var getAllAgenciesQuery = new GetAllAgenciesQuery();
        var agencies = agencyQueryService.handle(getAllAgenciesQuery);
        var agencyResources = agencies.stream().map(AgencyResourceFromEntityAssembler::toResourceFromEntity).collect(Collectors.toList());
        return ResponseEntity.ok(agencyResources);
    }

}
