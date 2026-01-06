package com.agrimarket.inventories.domain.model.exceptions;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public class EquipmentNotFoundException extends RuntimeException{
    public EquipmentNotFoundException(String message) {
        super(message);
    }
}
