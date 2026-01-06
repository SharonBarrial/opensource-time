package com.smarthome.platform.practica1.analytics.interfaces.rest.transform;

import com.smarthome.platform.practica1.analytics.domain.model.commands.CreatePerformanceIndicatorCommand;
import com.smarthome.platform.practica1.analytics.interfaces.rest.resources.CreatePerformanceIndicatorResource;

public class CreatePerformanceIndicatorCommandFromResourceAssembler {
    public static CreatePerformanceIndicatorCommand toCommandFromResource(CreatePerformanceIndicatorResource resource) {
        return new CreatePerformanceIndicatorCommand(
                resource.name(),
                resource.description(),
                resource.minValue(),
                resource.maxValue(),
                resource.deviceType()
        );
    }
}
