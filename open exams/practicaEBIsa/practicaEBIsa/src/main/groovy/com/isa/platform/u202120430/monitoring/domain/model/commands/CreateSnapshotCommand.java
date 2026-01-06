package com.isa.platform.u202120430.monitoring.domain.model.commands;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public record CreateSnapshotCommand(
        Long productId,
        String productSerialNumber,
        Double temperature,
        Double energy,
        Integer leakage
) {
}
