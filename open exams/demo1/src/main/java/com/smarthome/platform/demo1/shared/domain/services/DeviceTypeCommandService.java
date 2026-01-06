package com.smarthome.platform.demo1.shared.domain.services;

import com.smarthome.platform.demo1.shared.domain.model.commands.SeedDeviceTypeCommand;

/**
 * DeviceTypeCommandService
 * <p>
 *     Interface to handle the device type command.
 *     This interface is used to handle the device type command.
 *     The command is used to seed the device types in the database.
 * </p>
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public interface DeviceTypeCommandService {

    Long handle(SeedDeviceTypeCommand command);
}
