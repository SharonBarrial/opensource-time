package com.smarthome.platform.practica1.analytics.application.internal.commandservices;

import com.smarthome.platform.practica1.analytics.domain.model.aggregates.PerformanceIndicator;
import com.smarthome.platform.practica1.analytics.domain.model.commands.CreatePerformanceIndicatorCommand;
import com.smarthome.platform.practica1.analytics.domain.model.valueobjects.Description;
import com.smarthome.platform.practica1.analytics.domain.model.valueobjects.MaxValue;
import com.smarthome.platform.practica1.analytics.domain.model.valueobjects.MinValue;
import com.smarthome.platform.practica1.analytics.domain.model.valueobjects.Name;
import com.smarthome.platform.practica1.analytics.domain.services.PerformanceIndicatorCommandService;
import com.smarthome.platform.practica1.analytics.infrastructure.persistence.jpa.repositories.PerformanceIndicatorRepository;
import com.smarthome.platform.practica1.shared.infrastructure.persistence.jpa.repositories.DeviceTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PerformanceIndicatorCommandServiceImpl implements PerformanceIndicatorCommandService {
    private final PerformanceIndicatorRepository performanceIndicatorRepository;
    private final DeviceTypeRepository deviceTypeRepository;

    public PerformanceIndicatorCommandServiceImpl(PerformanceIndicatorRepository performanceIndicatorRepository, DeviceTypeRepository deviceTypeRepository) {
        this.performanceIndicatorRepository = performanceIndicatorRepository;
        this.deviceTypeRepository = deviceTypeRepository;
    }

    @Override
    public Optional<PerformanceIndicator> handle(CreatePerformanceIndicatorCommand command) {
        // check if device type exists
        var deviceType = deviceTypeRepository.findByType(command.deviceType().toUpperCase())
                .orElseThrow(() -> new IllegalArgumentException("Device type not found"));

        // check if there's another performance indicator with the same device type
        performanceIndicatorRepository.findByDeviceType(deviceType)
                .ifPresent(performanceIndicator -> {
                    throw new IllegalArgumentException("Performance indicator already exists for device type");
                });

        // check if minValue is less than maxValue
        if (command.minValue() >= command.maxValue()) {
            throw new IllegalArgumentException("Min value must be less than max value");
        }

        var name = new Name(command.name());
        var description = new Description(command.description());
        var minValue = new MinValue(command.minValue());
        var maxValue = new MaxValue(command.maxValue());

        var performanceIndicator = new PerformanceIndicator(name, description, minValue, maxValue, deviceType);
        try {
            performanceIndicatorRepository.save(performanceIndicator);
        } catch(Exception e) {
            throw new IllegalArgumentException("Error saving performance indicator: " + e.getMessage());
        }
        return Optional.of(performanceIndicator);
    }
}
