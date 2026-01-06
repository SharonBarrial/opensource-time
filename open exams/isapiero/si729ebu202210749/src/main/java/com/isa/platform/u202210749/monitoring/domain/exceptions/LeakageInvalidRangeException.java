package com.isa.platform.u202210749.monitoring.domain.exceptions;

public class LeakageInvalidRangeException extends RuntimeException{
    public LeakageInvalidRangeException(Integer leakage) {
        super("Leakage value " + leakage + " is invalid. It should be 0 or 1");
    }
}
