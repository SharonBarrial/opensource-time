package com.isa.platform.u20221b127.monitoring.interfaces.rest.resources;

public record SnapshotResource(
        Long id,
        String snapshotId,
        String productSerialNumber,
        Double temperature,
        Double energy,
        Integer leakage) {}