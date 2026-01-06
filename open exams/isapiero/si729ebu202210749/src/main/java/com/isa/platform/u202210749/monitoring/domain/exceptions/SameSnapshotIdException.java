package com.isa.platform.u202210749.monitoring.domain.exceptions;

public class SameSnapshotIdException extends RuntimeException{
    public SameSnapshotIdException(String snapshotId) {
        super("Snapshot with snapshotId " + snapshotId + " already exists");
    }
}
