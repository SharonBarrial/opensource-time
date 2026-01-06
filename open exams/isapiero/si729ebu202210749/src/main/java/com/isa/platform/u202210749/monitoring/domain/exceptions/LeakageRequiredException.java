package com.isa.platform.u202210749.monitoring.domain.exceptions;

public class LeakageRequiredException extends RuntimeException{
    public LeakageRequiredException() {
        super("Leakage value is required for products with Advance Monitoring level");
    }
}
