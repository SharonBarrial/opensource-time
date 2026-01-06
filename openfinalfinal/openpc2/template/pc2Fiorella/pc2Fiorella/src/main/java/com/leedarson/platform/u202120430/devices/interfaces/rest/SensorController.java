package com.leedarson.platform.u202120430.devices.interfaces.rest;

import com.leedarson.platform.u202120430.devices.domain.model.queries.GetSensorByIdQuery;
import com.leedarson.platform.u202120430.devices.interfaces.rest.resources.CreateSensorResource;
import com.leedarson.platform.u202120430.devices.interfaces.rest.resources.SensorResource;
import com.leedarson.platform.u202120430.devices.interfaces.rest.transform.CreateSensorCommandFromResourceAssembler;
import com.leedarson.platform.u202120430.devices.interfaces.rest.transform.SensorResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.leedarson.platform.u202120430.devices.domain.services.SensorCommandService;
import com.leedarson.platform.u202120430.devices.domain.services.SensorQueryService;

/**
 * SensorController class
 * @author Nadia Alessandra Lucas Coronel
 * @version 1.0
 */

@RestController
@RequestMapping(value = "/api/v1/sensors", produces =  MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Sensors", description = "Sensors Management Endpoints")
public class SensorController {
    private final SensorCommandService sensorCommandService;
    private final SensorQueryService sensorQueryService;

    public SensorController(SensorCommandService sensorCommandService, SensorQueryService sensorQueryService) {
        this.sensorCommandService = sensorCommandService;
        this.sensorQueryService = sensorQueryService;
    }


    // POST method to create a new sensor
    @PostMapping
    public ResponseEntity<SensorResource> createSensor(@RequestBody CreateSensorResource res) {
        var createSensorCommand = CreateSensorCommandFromResourceAssembler.toCommandFromResource(res);
        var sensorId = sensorCommandService.handle(createSensorCommand);
        if (sensorId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getSensorByIdQuery = new GetSensorByIdQuery(sensorId);
        var sensor = sensorQueryService.handle(getSensorByIdQuery);
        if (sensor.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var sensorResource = SensorResourceFromEntityAssembler.toResourceFromEntity(sensor.get());
        return new ResponseEntity<>(sensorResource, HttpStatus.CREATED);
    }
}
