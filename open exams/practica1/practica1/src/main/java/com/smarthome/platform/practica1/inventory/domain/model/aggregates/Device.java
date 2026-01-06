package com.smarthome.platform.practica1.inventory.domain.model.aggregates;

import com.smarthome.platform.practica1.inventory.domain.model.valueobjects.InstallationDate;
import com.smarthome.platform.practica1.inventory.domain.model.valueobjects.Model;
import com.smarthome.platform.practica1.inventory.domain.model.valueobjects.SerialNumber;
import com.smarthome.platform.practica1.inventory.domain.model.valueobjects.Status;
import com.smarthome.platform.practica1.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.smarthome.platform.practica1.shared.domain.model.entities.DeviceType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

/**
 * Device Entity
 * <p>
 *     Represents a Device entity.
 *     A Device is a physical device that can be installed in a Smart Home.
 * </p>
 * @see AuditableAbstractAggregateRoot
 * @author Salvador Salinas
 * @version 1.0
 */
@Entity
public class Device extends AuditableAbstractAggregateRoot<Device> {
    @Embedded
    @NotNull(message = "Serial number is required")
    private SerialNumber serialNumber;

    @Embedded
    @NotNull(message = "Model is required")
    private Model model;

    @ManyToOne
    @JoinColumn(nullable = false, name = "device_type_id")
    private DeviceType deviceType;

    @Embedded
    @NotNull(message = "Installation date is required")
    private InstallationDate installationDate;

    @Embedded
    @NotNull(message = "Status is required")
    private Status status;

    public Device() {}

    public Device(SerialNumber serialNumber, Model model, DeviceType deviceType, InstallationDate installationDate, Status status) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.deviceType = deviceType;
        this.installationDate = installationDate;
        this.status = status;
    }

    public void update(SerialNumber serialNumber, Model model, DeviceType deviceType, InstallationDate installationDate, Status status) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.deviceType = deviceType;
        this.installationDate = installationDate;
        this.status = status;
    }

    public String getSerialNumber() {
        return serialNumber.serialNumber();
    }

    public String getModel() {
        return model.model();
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public Date getInstallationDate() {
        return installationDate.installationDate();
    }

    public String getStatus() {
        return status.status();
    }


}
