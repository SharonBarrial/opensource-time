package com.isa.platform.u202120430.monitoring.interfaces.rest.resources;

import jakarta.validation.constraints.NotNull;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public record CreateSnapshotResource(
        @NotNull Long productId,
        @NotNull String productSerialNumber,
        @NotNull Double temperature,
        @NotNull Double energy,
        @NotNull Integer leakage
) {
}
