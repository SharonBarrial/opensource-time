package com.smarthomemanagement.platform.tareaopensem14.inventory.domain.exceptions;

/**
 * @author Sharon Antuanet Ivet Barrial Marin  - u202114900
 * @version 1.0
 */
public class DeviceTypeNotFoundException extends RuntimeException {
    public DeviceTypeNotFoundException(Long aLong) {
        super("Device type with id " + aLong + " not found");
    }
}
