package com.smarthome.platform.demo1.shared.application.internal.commandservices;

import com.smarthome.platform.demo1.shared.domain.model.commands.SeedDeviceTypeCommand;
import com.smarthome.platform.demo1.shared.domain.model.entities.DeviceType;
import com.smarthome.platform.demo1.shared.domain.model.valueobjects.DeviceTypeName;
import com.smarthome.platform.demo1.shared.domain.services.DeviceTypeCommandService;
import com.smarthome.platform.demo1.shared.infrastructure.persistence.jpa.repositories.DeviceTypeRepository;
import org.springframework.stereotype.Service;

/**
 * DeviceTypeCommandServiceImpl
 * <p>
 *     This class implements the DeviceTypeCommandService interface.
 *     This class is used to handle the device type command.
 *     The command is used to seed the device types in the database.
 * </p>
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

@Service
public class DeviceTypeCommandServiceImpl implements DeviceTypeCommandService {

    private final DeviceTypeRepository deviceTypeRepository;

    public DeviceTypeCommandServiceImpl(DeviceTypeRepository deviceTypeRepository) {
        this.deviceTypeRepository = deviceTypeRepository;
    }

    /**
     * Handle the device type command.
     * <p>
     *     This method is used to handle the device type command.
     *     The command is used to seed the device types in the database.
     * </p>
     * @param command The command to seed the device types in the database.
     * @return The last id of the device type seeded in the database.
     */

    @Override
    public Long handle(SeedDeviceTypeCommand command) {
        DeviceTypeName[] deviceTypeNames = DeviceTypeName.values();
        Long lastId = null;

        for (DeviceTypeName deviceTypeName : deviceTypeNames) {
            if (!deviceTypeRepository.existsByName(deviceTypeName)) {
                var deviceType = new DeviceType(deviceTypeName);
                deviceTypeRepository.save(deviceType);
                lastId = deviceType.getId();
            }
        }
        return lastId;
    }


}
