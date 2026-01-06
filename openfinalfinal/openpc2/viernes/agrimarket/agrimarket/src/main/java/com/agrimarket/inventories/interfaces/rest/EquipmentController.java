package com.agrimarket.inventories.interfaces.rest;

import com.agrimarket.inventories.domain.model.queries.GetEquipmentByIdQuery;
import com.agrimarket.inventories.domain.services.EquipmentCommandService;
import com.agrimarket.inventories.domain.services.EquipmentQueryService;
import com.agrimarket.inventories.interfaces.rest.resource.CreateEquipmentResource;
import com.agrimarket.inventories.interfaces.rest.resource.EquipmentResource;
import com.agrimarket.inventories.interfaces.rest.transform.CreateEquipmentCommandFromResourceAssembler;
import com.agrimarket.inventories.interfaces.rest.transform.EquipmentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * EquipmentController class
 * This class is responsible for handling the REST API endpoints for equipment management
 * @version 1.0
 * @author Sharon Antuanet Ivet Barrial Marin
 */

@RestController
@RequestMapping(value ="/api/v1/equipments", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Equipments", description = "Equipments Management Endpoints")
public class EquipmentController {
    private final EquipmentCommandService equipmentCommandService;
    private final EquipmentQueryService equipmentQueryService;

    public EquipmentController(EquipmentCommandService equipmentCommandService, EquipmentQueryService equipmentQueryService) {
        this.equipmentCommandService = equipmentCommandService;
        this.equipmentQueryService = equipmentQueryService;
    }



    // POST method to create a new equipment
    @PostMapping
    //RequestBody annotation binds the HTTPRequest body to the domain object
    public ResponseEntity<EquipmentResource> createEquipment(@RequestBody CreateEquipmentResource res) {
        var createEquipmentCommand = CreateEquipmentCommandFromResourceAssembler.toCommandFromResource(res);
        var equipmentId = equipmentCommandService.handle(createEquipmentCommand);
        if (equipmentId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getEquipmentByIdQuery = new GetEquipmentByIdQuery(equipmentId);
        var equipment = equipmentQueryService.handle(getEquipmentByIdQuery);
        if (equipment.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var equipmentResource = EquipmentResourceFromEntityAssembler.toResourceFromEntity(equipment.get());
        return new ResponseEntity<>(equipmentResource, HttpStatus.CREATED);
    }

}
