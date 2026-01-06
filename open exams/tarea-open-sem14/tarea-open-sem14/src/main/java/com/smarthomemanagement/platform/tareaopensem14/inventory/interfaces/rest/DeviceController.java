package com.smarthomemanagement.platform.tareaopensem14.inventory.interfaces.rest;

import com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.queries.GetDeviceByIdQuery;
import com.smarthomemanagement.platform.tareaopensem14.inventory.domain.services.DeviceCommandService;
import com.smarthomemanagement.platform.tareaopensem14.inventory.domain.services.DeviceQueryService;
import com.smarthomemanagement.platform.tareaopensem14.inventory.interfaces.rest.resources.CreateDeviceResource;
import com.smarthomemanagement.platform.tareaopensem14.inventory.interfaces.rest.resources.DeviceResource;
import com.smarthomemanagement.platform.tareaopensem14.inventory.interfaces.rest.transform.CreateDeviceCommandFromResourceAssembler;
import com.smarthomemanagement.platform.tareaopensem14.inventory.interfaces.rest.transform.DeviceResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sharon Antuanet Ivet Barrial Marin  - u202114900
 * @version 1.0
 */

@RestController
@RequestMapping(value = "api/v1/devices", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Devices", description = "Devices Management Endpoints")
public class DeviceController {
    private final DeviceCommandService deviceCommandService;
    private final DeviceQueryService deviceQueryService;

    public DeviceController(DeviceCommandService deviceCommandService, DeviceQueryService deviceQueryService) {
        this.deviceCommandService = deviceCommandService;
        this.deviceQueryService = deviceQueryService;
    }

    @PostMapping
    public ResponseEntity<DeviceResource> createDevice(@RequestBody CreateDeviceResource res) {
        var createDeviceCommand = CreateDeviceCommandFromResourceAssembler.toCommandFromResource(res);
        var deviceId = deviceCommandService.handle(createDeviceCommand);
        if (deviceId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getDeviceByIdQuery = new GetDeviceByIdQuery(deviceId);
        var device = deviceQueryService.handle(getDeviceByIdQuery);
        if (device.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var deviceResource = DeviceResourceFromEntityAssembler.toResourceFromEntity(device.get());
        return new ResponseEntity<>(deviceResource, HttpStatus.CREATED);
    }
}
