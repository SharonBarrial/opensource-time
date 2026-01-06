package com.smarthome.platform.practica1.shared.application.internal.eventhandlers;

import com.smarthome.platform.practica1.shared.domain.model.commands.CreateDeviceTypeCommand;
import com.smarthome.platform.practica1.shared.domain.model.queries.GetAllDeviceTypesQuery;
import com.smarthome.platform.practica1.shared.domain.services.DeviceTypeCommandService;
import com.smarthome.platform.practica1.shared.domain.services.DeviceTypeQueryService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ApplicationReadyEventHandler {
    private final DeviceTypeCommandService deviceTypeCommandService;
    private final DeviceTypeQueryService deviceTypeQueryService;

    public ApplicationReadyEventHandler(DeviceTypeCommandService deviceTypeCommandService, DeviceTypeQueryService deviceTypeQueryService) {
        this.deviceTypeCommandService = deviceTypeCommandService;
        this.deviceTypeQueryService = deviceTypeQueryService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void on() {
        var getAllDeviceTypesQuery = new GetAllDeviceTypesQuery();
        var deviceTypes = deviceTypeQueryService.handle(getAllDeviceTypesQuery);
        if (deviceTypes.isEmpty()) {
            deviceTypeCommandService.handle(new CreateDeviceTypeCommand("LIGHTING"));
            deviceTypeCommandService.handle(new CreateDeviceTypeCommand("HEATING"));
            deviceTypeCommandService.handle(new CreateDeviceTypeCommand("SECURITY"));
            System.out.println("Device types created");
        }
        else {
            System.out.println("Device types already created");
        }
    }
}
