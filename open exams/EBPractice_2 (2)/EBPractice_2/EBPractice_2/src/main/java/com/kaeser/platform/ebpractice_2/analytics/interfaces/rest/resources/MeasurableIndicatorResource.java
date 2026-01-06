package com.kaeser.platform.ebpractice_2.analytics.interfaces.rest.resources;

/**
 * @author Fiorella Jarama Peñaloza
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
