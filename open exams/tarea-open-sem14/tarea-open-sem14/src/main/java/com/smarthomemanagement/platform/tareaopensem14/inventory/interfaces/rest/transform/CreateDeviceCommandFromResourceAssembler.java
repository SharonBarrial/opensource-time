package com.smarthomemanagement.platform.tareaopensem14.inventory.interfaces.rest.transform;

import com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.commands.CreateDeviceCommand;
import com.smarthomemanagement.platform.tareaopensem14.inventory.interfaces.rest.resources.CreateDeviceResource;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public class CreateDeviceCommandFromResourceAssembler {
    public static CreateDeviceCommand toCommandFromResource(CreateDeviceResource resource) {
        return new CreateDeviceCommand(
                resource.serialNumber(),
                resource.model(),
                resource.deviceTypeId(),
                resource.installationDate(),
                resource.status());
    }
}
