package com.smarthome.platform.practica1.analytics.domain.services;

import com.smarthome.platform.practica1.analytics.domain.model.aggregates.PerformanceIndicator;
import com.smarthome.platform.practica1.analytics.domain.model.commands.CreatePerformanceIndicatorCommand;

import java.util.Optional;

public interface PerformanceIndicatorCommandService {
    Optional<PerformanceIndicator> handle(CreatePerformanceIndicatorCommand command);
}
