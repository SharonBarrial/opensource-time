package com.isa.platform.u20221b127.monitoring.interfaces.rest.resources;

public record CreateSnapshotResource(
        String snapshotId,
        Double temperature,
        Double energy,
        Integer leakage) {}