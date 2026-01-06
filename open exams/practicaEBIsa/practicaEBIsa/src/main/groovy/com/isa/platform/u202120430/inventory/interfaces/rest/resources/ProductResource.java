package com.isa.platform.u202120430.inventory.interfaces.rest.resources;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public record ProductResource(
        Long id,
        String brand,
        String model,
        String serialNumber,
        String monitoringLevel
) {
}
