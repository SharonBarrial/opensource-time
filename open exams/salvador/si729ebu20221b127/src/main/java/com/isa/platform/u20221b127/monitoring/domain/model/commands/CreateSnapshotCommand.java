package com.isa.platform.u20221b127.monitoring.domain.model.commands;

public record CreateSnapshotCommand(String snapshotId, Double temperature, Double energy, Integer leakage) {
}
