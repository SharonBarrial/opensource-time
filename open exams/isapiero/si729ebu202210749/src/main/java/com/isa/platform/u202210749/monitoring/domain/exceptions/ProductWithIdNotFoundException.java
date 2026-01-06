package com.isa.platform.u202210749.monitoring.domain.exceptions;

public class ProductWithIdNotFoundException extends RuntimeException{
    public ProductWithIdNotFoundException(Long id) {
        super("Product with id " + id + " not found");
    }
}
