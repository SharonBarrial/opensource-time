package com.smarthome.platform.practica1.inventory.interfaces.rest;

import com.smarthome.platform.practica1.inventory.domain.model.queries.GetAllDevicesQuery;
import com.smarthome.platform.practica1.inventory.domain.services.DeviceCommandService;
import com.smarthome.platform.practica1.inventory.domain.services.DeviceQueryService;
import com.smarthome.platform.practica1.inventory.interfaces.rest.resources.CreateDeviceResource;
import com.smarthome.platform.practica1.inventory.interfaces.rest.resources.DeviceResource;
import com.smarthome.platform.practica1.inventory.interfaces.rest.resources.UpdateDeviceResource;
import com.smarthome.platform.practica1.inventory.interfaces.rest.transform.CreateDeviceCommandFromResourceAssembler;
import com.smarthome.platform.practica1.inventory.interfaces.rest.transform.DeviceResourceFromEntityAssembler;
import com.smarthome.platform.practica1.inventory.interfaces.rest.transform.UpdateDeviceCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Devices Controller
 * <p>
 *     This class represents the REST API for the devices.
 *     It provides endpoints to get all devices, create a device and update a device.
 * </p>
 * @author Salvador Salinas
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/v1/devices", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Devices", description = "Devices Endpoints")
public class DevicesController {
    private final DeviceCommandService deviceCommandService;
    private final DeviceQueryService deviceQueryService;

    public DevicesController(DeviceCommandService deviceCommandService, DeviceQueryService deviceQueryService) {
        this.deviceCommandService = deviceCommandService;
        this.deviceQueryService = deviceQueryService;
    }

    @Operation(summary = "Get all devices")
    @GetMapping
    public ResponseEntity<List<DeviceResource>> getAllDevices() {
        var getAllDevicesQuery = new GetAllDevicesQuery();
        var devices = deviceQueryService.handle(getAllDevicesQuery);
        var deviceResources = devices.stream()
                .map(DeviceResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(deviceResources);
    }

    @Operation(summary = "Create a device")
    @PostMapping
    public ResponseEntity<DeviceResource> createDevice(@RequestBody CreateDeviceResource resource) {
        var createDeviceCommand = CreateDeviceCommandFromResourceAssembler.toCommandFromResource(resource);
        var device = deviceCommandService.handle(createDeviceCommand);
        if (device.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var deviceResource = DeviceResourceFromEntityAssembler.toResourceFromEntity(device.get());
        return new ResponseEntity<>(deviceResource, HttpStatus.CREATED);
    }

    @Operation(summary = "Update a device")
    @PutMapping("/{id}")
    public ResponseEntity<DeviceResource> updateDevice(@PathVariable Long id, @RequestBody UpdateDeviceResource resource) {
        var updateDeviceCommand = UpdateDeviceCommandFromResourceAssembler.toCommandFromResource(resource, id);
        var device = deviceCommandService.handle(updateDeviceCommand);
        if (device.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var deviceResource = DeviceResourceFromEntityAssembler.toResourceFromEntity(device.get());
        return ResponseEntity.ok(deviceResource);
    }
}
