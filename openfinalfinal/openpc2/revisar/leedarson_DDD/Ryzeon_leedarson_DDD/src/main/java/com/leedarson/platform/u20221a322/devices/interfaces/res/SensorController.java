package com.leedarson.platform.u20221a322.devices.interfaces.res;

import com.leedarson.platform.u20221a322.devices.domain.services.SensorCommandService;
import com.leedarson.platform.u20221a322.devices.interfaces.res.resources.CreateSensorResource;
import com.leedarson.platform.u20221a322.devices.interfaces.res.resources.SensorResource;
import com.leedarson.platform.u20221a322.devices.interfaces.res.transforms.CreateSensorCommandFromResourceAssembler;
import com.leedarson.platform.u20221a322.devices.interfaces.res.transforms.SensorResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Alex Avila Asto - A.K.A (Ryzeon)
 * Project: leedarson
 * Date: 12/06/24 @ 01:51
 */
@RestController
@RequestMapping(value = "/api/v1/sensors", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Sensor", description = "Sensor Controller")
public class SensorController {

    private final SensorCommandService sensorCommandService;

    public SensorController(SensorCommandService sensorCommandService) {
        this.sensorCommandService = sensorCommandService;
    }

    /**
     * @param resource CreateSensorResource
     * @summary Receives a resource, transforms it into a command, and it's handled by the service
     * @return SensorResource as response with status CREATED (201)
     * @author Alex Avila Asto
     */
    @PostMapping
    public ResponseEntity<SensorResource> createSensor(@RequestBody CreateSensorResource resource) {
        var createSensorCommand = CreateSensorCommandFromResourceAssembler.toCommandFromResource(resource);
        var sensorEntity = sensorCommandService.handle(createSensorCommand);
        if (sensorEntity.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var sensorResource = SensorResourceFromEntityAssembler.toResourceFromEntity(sensorEntity.get());
        return new ResponseEntity<>(sensorResource, HttpStatus.CREATED);
    }
}
