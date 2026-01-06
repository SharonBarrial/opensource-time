package com.kaeser.platform.ebpractice_2.analytics.domain.model.commands;

/**
 * CreateMeasurableIndicator - Command for creating a measurable indicator.
 *
 * @author Fiorella Jarama Peñaloza
 */
public record CreateMeasurableIndicatorCommand(
        String symbol,
        String description,
        Double thresholdMaximum,
        Double thresholdMinimum,
        String equipmentTypeName
) {
}
