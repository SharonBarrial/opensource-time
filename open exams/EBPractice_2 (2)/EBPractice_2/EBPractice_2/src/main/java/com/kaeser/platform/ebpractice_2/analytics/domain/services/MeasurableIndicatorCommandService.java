package com.kaeser.platform.ebpractice_2.analytics.domain.services;

import com.kaeser.platform.ebpractice_2.analytics.domain.model.commands.CreateMeasurableIndicatorCommand;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
public interface MeasurableIndicatorCommandService {
    Long handle(CreateMeasurableIndicatorCommand command);
}
