package com.isa.platform.u202210749.monitoring.interfaces.rest.resources;

public record CreateSnapshotResource(String snapshotId, String productSerialNumber, Double temperature, Double energy, Integer leakage) {
}
