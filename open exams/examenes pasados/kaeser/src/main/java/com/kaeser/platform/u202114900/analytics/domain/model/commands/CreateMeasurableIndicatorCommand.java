package com.kaeser.platform.u202114900.analytics.domain.model.commands;

/**
 * CreateMeasurableIndicatorCommand
 * <p>
 *     This class represents the command to create a measurable indicator
 *  * It contains the symbol, description, threshold maximum, threshold minimum, and equipment type name.
 *  * It also contains the getters for the symbol, description, threshold maximum, threshold minimum, and equipment type name.
 *  * It contains a constructor with parameters for the symbol, description, threshold maximum, threshold minimum, and equipment type name.
 * </p>
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public record CreateMeasurableIndicatorCommand(
        String symbol,
        String description,
        Double thresholdMaximum,
        Double thresholdMinimum,
        String equipmentTypeName
) {
}
