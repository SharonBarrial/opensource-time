package com.isa.platform.u202120430.monitoring.interfaces.rest.resources;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public record SnapshotResource(
        Long id,
        Long productId,
        String productSerialNumber,
        Double temperature,
        Double energy,
        Integer leakage
) {
}
