package com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.commands;

import java.time.LocalDate;

/**
 * @author Sharon Antuanet Ivet Barrial Marin  - u202114900
 * @version 1.0
 */
public record CreateDeviceCommand(
        String serialNumber,
        String model,
        Long deviceTypeId,
        LocalDate installationDate,
        String status
) {
}
