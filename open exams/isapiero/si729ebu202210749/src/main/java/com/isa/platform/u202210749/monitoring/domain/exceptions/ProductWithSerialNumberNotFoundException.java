package com.isa.platform.u202210749.monitoring.domain.exceptions;

public class ProductWithSerialNumberNotFoundException extends RuntimeException{
    public ProductWithSerialNumberNotFoundException(String serialNumber) {
        super("Product with serial number " + serialNumber + " not found");
    }
}
