package com.kaeser.platform.u202114900.inventory.domain.exceptions;

/**
 * EquipmentTypeNotFoundException class
 * <p>
 *     This class represents the exception that is thrown when an equipment type is not found.
 *     It extends the RuntimeException class.
 *     It contains the constructor that receives the id of the equipment type.
 * </p>
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public class EquipmentTypeNotFoundException extends RuntimeException{
    public EquipmentTypeNotFoundException(String aLong) {
        super("Equipment type with id " + aLong + " not found");
    }
}
