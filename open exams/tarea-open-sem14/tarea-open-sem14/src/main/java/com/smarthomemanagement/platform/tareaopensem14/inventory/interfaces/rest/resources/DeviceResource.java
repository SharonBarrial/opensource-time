package com.smarthomemanagement.platform.tareaopensem14.inventory.interfaces.rest.resources;

import java.time.LocalDate;

/**
 * @author Sharon Antuanet Ivet Barrial Marin  - u202114900
 * @version 1.0
 */
public record DeviceResource(
        Long id,
        String serialNumber,
        String model,
        Long deviceTypeId,
        LocalDate installationDate,
        String status
) {
}
