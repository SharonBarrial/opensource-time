package com.kaeser.platform.ebpractice_2.analytics.interfaces.rest.resources;

/**
 * This class is a resource class that will be used to create a measurable indicator.
 *
 * @author Fiorella Jarama Peñaloza
 */
public record CreateMeasurableIndicatorResource(
        String symbol,
        String description,
        Double thresholdMaximum,
        Double thresholdMinimum,
        String equipmentTypeName
) {
}
