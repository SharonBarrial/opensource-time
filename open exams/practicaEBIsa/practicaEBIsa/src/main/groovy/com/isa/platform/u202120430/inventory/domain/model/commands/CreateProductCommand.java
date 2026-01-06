package com.isa.platform.u202120430.inventory.domain.model.commands;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public record CreateProductCommand(
        String brand,
        String model,
        String serialNumber,
        String monitoringLevel
) {
}
