package com.isa.platform.u202210749.inventory.domain.exceptions;

public class MonitoringLevelNotFoundException extends RuntimeException{
    public MonitoringLevelNotFoundException(Long monitoringLevelId) {
        super("Monitoring level with id " + monitoringLevelId + " not found");
    }
}
