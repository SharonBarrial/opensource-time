package com.kaeser.platform.u202114900.analytics.interfaces.rest.resources;

/**
 * CreateMeasurableIndicatorResource class
 * <p>
 *     This class represents the resource to create a measurable indicator.
 *     It contains the symbol, description, maximum threshold, minimum threshold and equipment type name of the measurable indicator.
 *     It is used by the MeasurableIndicatorCommandController class.
 * </p>
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public record CreateMeasurableIndicatorResource(
        String symbol,
        String description,
        Double thresholdMaximum,
        Double thresholdMinimum,
        String equipmentTypeName
) {
}
