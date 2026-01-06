package com.kaeser.platform.u202114900.inventory.interfaces.rest;

import com.kaeser.platform.u202114900.inventory.domain.model.queries.GetEquipmentById;
import com.kaeser.platform.u202114900.inventory.domain.services.EquipmentCommandService;
import com.kaeser.platform.u202114900.inventory.domain.services.EquipmentQueryService;
import com.kaeser.platform.u202114900.inventory.interfaces.rest.resources.CreateEquipmentResource;
import com.kaeser.platform.u202114900.inventory.interfaces.rest.resources.EquipmentResource;
import com.kaeser.platform.u202114900.inventory.interfaces.rest.transform.CreateEquipmentCommandFromResourceAssembler;
import com.kaeser.platform.u202114900.inventory.interfaces.rest.transform.EquipmentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

@RestController
@RequestMapping(value = "api/v1/equipments", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Equipments", description = "Equipments Management Endpoints")
public class EquipmentController {
    private final EquipmentCommandService equipmentCommandService;
    private final EquipmentQueryService equipmentQueryService;

    public EquipmentController(EquipmentCommandService equipmentCommandService, EquipmentQueryService equipmentQueryService) {
        this.equipmentCommandService = equipmentCommandService;
        this.equipmentQueryService = equipmentQueryService;
    }

    @PostMapping
    public ResponseEntity<EquipmentResource> createDevice(@RequestBody CreateEquipmentResource res) {
        var createEquipmentCommand = CreateEquipmentCommandFromResourceAssembler.toCommandFromResource(res);
        var equipmentId = equipmentCommandService.handle(createEquipmentCommand);
        if (equipmentId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getEquipmentByIdQuery = new GetEquipmentById(equipmentId);
        var equipment = equipmentQueryService.handle(getEquipmentByIdQuery);
        if (equipment.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var equipmentResource = EquipmentResourceFromEntityAssembler.toResourceFromEntity(equipment.get());
        return new ResponseEntity<>(equipmentResource, HttpStatus.CREATED);
    }
}
