package com.isa.platform.u202210749.monitoring.domain.model.commands;

public record CreateSnapshotCommand(String snapshotId, String productSerialNumber, Double temperature, Double energy, Integer leakage) {
}
