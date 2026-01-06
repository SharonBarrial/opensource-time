package com.smarthomemanagement.platform.tareaopensem14.shared.aplication.nternal.commandservices;

import com.smarthomemanagement.platform.tareaopensem14.shared.domain.model.commands.SeedDeviceTypeCommand;
import com.smarthomemanagement.platform.tareaopensem14.shared.domain.model.entities.DeviceType;
import com.smarthomemanagement.platform.tareaopensem14.shared.domain.model.valueobjects.DeviceTypeName;
import com.smarthomemanagement.platform.tareaopensem14.shared.domain.services.DeviceTypeCommandService;
import com.smarthomemanagement.platform.tareaopensem14.shared.infrastructure.persistence.jpa.repositories.DeviceTypeRepository;
import org.springframework.stereotype.Service;

/**
 * @author Vargas Revollé, Ariana - u20221928
 * @version 1.0
 */

@Service
public class DeviceTypeCommandServiceImpl implements DeviceTypeCommandService {

    private final DeviceTypeRepository deviceTypeRepository;

    public DeviceTypeCommandServiceImpl(DeviceTypeRepository deviceTypeRepository) {
        this.deviceTypeRepository = deviceTypeRepository;
    }

    @Override
    public Long handle(SeedDeviceTypeCommand command) {
        DeviceTypeName[] deviceTypeNames = DeviceTypeName.values();
        Long lastId = null;

        for (DeviceTypeName deviceTypeName : deviceTypeNames) {
            if (!deviceTypeRepository.existsByType(deviceTypeName)) {
                var deviceType = new DeviceType(deviceTypeName);
                deviceTypeRepository.save(deviceType);
                lastId = deviceType.getId();
            }
        }
        return lastId;
    }
}
