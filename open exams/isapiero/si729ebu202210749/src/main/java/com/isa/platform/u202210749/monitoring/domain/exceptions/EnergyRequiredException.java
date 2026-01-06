package com.isa.platform.u202210749.monitoring.domain.exceptions;

public class EnergyRequiredException extends RuntimeException{
    public EnergyRequiredException() {
        super("Energy is required for products with Advance Monitoring level");
    }
}
