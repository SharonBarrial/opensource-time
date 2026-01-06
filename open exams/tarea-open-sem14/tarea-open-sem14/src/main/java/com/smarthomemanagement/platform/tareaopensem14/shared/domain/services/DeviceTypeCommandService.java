package com.smarthomemanagement.platform.tareaopensem14.shared.domain.services;

import com.smarthomemanagement.platform.tareaopensem14.shared.domain.model.commands.SeedDeviceTypeCommand;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */
public interface DeviceTypeCommandService {
    Long handle(SeedDeviceTypeCommand command);
}
