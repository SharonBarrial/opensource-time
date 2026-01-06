package com.kaeser.platform.u202114900.analytics.interfaces.rest.resources;

/**
 * MeasurableIndicatorResource class
 * <p>
 *     This class represents the resource of a measurable indicator.
 *     It contains the id, symbol, description, maximum threshold, minimum threshold and equipment type name of the measurable indicator.
 *     It is used by the MeasurableIndicatorQueryController class.
 * </p>
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public record MeasurableIndicatorResource(
        Long id,
        String symbol,
        String description,
        Double thresholdMaximum,
        Double thresholdMinimum,
        String equipmentTypeName
) {
}
