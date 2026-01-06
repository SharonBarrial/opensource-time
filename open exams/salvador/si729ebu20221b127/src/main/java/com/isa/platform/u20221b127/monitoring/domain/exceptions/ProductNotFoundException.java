package com.isa.platform.u20221b127.monitoring.domain.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long productId) {
        super("Product with id " + productId + " not found");
    }
}
