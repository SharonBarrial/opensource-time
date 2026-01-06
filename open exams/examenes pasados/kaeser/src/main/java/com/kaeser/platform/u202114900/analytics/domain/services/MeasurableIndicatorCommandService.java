package com.kaeser.platform.u202114900.analytics.domain.services;

import com.kaeser.platform.u202114900.analytics.domain.model.commands.CreateMeasurableIndicatorCommand;

/**
 * Interface for the MeasurableIndicatorCommandService
 * <p>
 *     This interface represents the service to handle the commands for the measurable indicators.
 *     It contains the method to handle the creation of a measurable indicator.
 *     It is implemented by the MeasurableIndicatorCommandServiceImpl class.
 * </p>
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public interface MeasurableIndicatorCommandService {
    Long handle(CreateMeasurableIndicatorCommand command);
}
