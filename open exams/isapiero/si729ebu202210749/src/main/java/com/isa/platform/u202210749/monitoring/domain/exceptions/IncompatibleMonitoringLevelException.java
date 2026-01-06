package com.isa.platform.u202210749.monitoring.domain.exceptions;

public class IncompatibleMonitoringLevelException extends RuntimeException{
    public IncompatibleMonitoringLevelException() {
        super("Snapshot Data not compatible with product current Monitoring Level");
    }
}
