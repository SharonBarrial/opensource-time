package com.smarthome.platform.practica1.analytics.interfaces.rest.transform;

import com.smarthome.platform.practica1.analytics.domain.model.aggregates.PerformanceIndicator;
import com.smarthome.platform.practica1.analytics.interfaces.rest.resources.PerformanceIndicatorResource;

public class PerformanceIndicatorResourceFromEntityAssembler {
    public static PerformanceIndicatorResource toResourceFromEntity(PerformanceIndicator entity) {
        return new PerformanceIndicatorResource(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getMinValue(),
                entity.getMaxValue(),
                entity.getDeviceType().getType()
        );
    }
}
