package com.isa.platform.u202120430.inventory.interfaces.rest.resources;

import jakarta.validation.constraints.NotNull;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public record CreateProductResource(
        @NotNull String brand,
        @NotNull String model,
        @NotNull String serialNumber,
        @NotNull String monitoringLevel
) {
}
