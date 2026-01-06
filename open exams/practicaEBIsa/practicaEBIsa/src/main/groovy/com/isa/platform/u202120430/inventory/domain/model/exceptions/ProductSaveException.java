package com.isa.platform.u202120430.inventory.domain.model.exceptions;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public class ProductSaveException extends RuntimeException {
    public ProductSaveException(String message, Throwable cause) {
        super(message, cause);
    }
}
