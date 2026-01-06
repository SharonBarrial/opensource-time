package com.smarthomemanagement.platform.tareaopensem14.inventory.interfaces.rest.resources;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public record CreateDeviceResource(
        @NotNull String serialNumber,
        @NotNull String model,
        @NotNull Long deviceTypeId,
        @NotNull LocalDate installationDate,
        @NotNull String status
) {
}
