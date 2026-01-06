package com.smarthomemanagement.platform.tareaopensem14.inventory.domain.services;

import com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.commands.CreateDeviceCommand;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public interface DeviceCommandService {
    Long handle(CreateDeviceCommand command);
}
