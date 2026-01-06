package com.kaeser.platform.ebpractice_2.inventory.domain.exceptions;

public class EquipmentTypeNotFoundException extends RuntimeException {
    public EquipmentTypeNotFoundException(String aLong) {
        super("Equipment type with id " + aLong + " not found");
    }
}
