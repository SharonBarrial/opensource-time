package com.isa.platform.u202120430.shared.domain.model.exceptions;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public class MonitoringLevelNotFoundException extends RuntimeException {
    public MonitoringLevelNotFoundException(String monitoringLevel) {
        super("Monitoring level not found: " + monitoringLevel);
    }
}
