package com.smarthomemanagement.platform.tareaopensem14.inventory.interfaces.rest.transform;

import com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.aggregates.Device;
import com.smarthomemanagement.platform.tareaopensem14.inventory.interfaces.rest.resources.DeviceResource;

/**
 * @author Sharon Antuanet Ivet Barrial Marin  - u202114900
 * @version 1.0
 */
public class DeviceResourceFromEntityAssembler {
    public static DeviceResource toResourceFromEntity(Device entity) {
        return new DeviceResource(
                entity.getId(),
                entity.getSerialNumber(),
                entity.getModel(),
                entity.getDeviceType().getId(),
                entity.getInstallationDate(),
                entity.getStatus()
        );
    }
}
