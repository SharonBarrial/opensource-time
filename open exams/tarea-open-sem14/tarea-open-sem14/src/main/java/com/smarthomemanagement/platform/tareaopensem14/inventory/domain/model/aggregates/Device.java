package com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.aggregates;

import com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.commands.CreateDeviceCommand;
import com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.valueobjects.InstallationDate;
import com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.valueobjects.Model;
import com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.valueobjects.SerialNumber;
import com.smarthomemanagement.platform.tareaopensem14.inventory.domain.model.valueobjects.Status;
import com.smarthomemanagement.platform.tareaopensem14.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.smarthomemanagement.platform.tareaopensem14.shared.domain.model.entities.DeviceType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author Sharon Antuanet Ivet Barrial Marin  - u202114900
 * @version 1.0
 */

@Getter
@Setter
@Entity
public class Device extends AuditableAbstractAggregateRoot<Device> {
    @Embedded
    private SerialNumber serialNumber;

    @Embedded
    private Model model;

    @ManyToOne
    @JoinColumn(name = "deviceType_id")
    private DeviceType deviceType;

    @Embedded
    private InstallationDate installationDate;

    @Embedded
    private Status status;

    public Device() {}

    public Device(SerialNumber serialNumber, Model model, DeviceType deviceType, InstallationDate installationDate, Status status) {
        this();
        this.serialNumber = serialNumber;
        this.model = model;
        // this is a foreign key of DeviceType
        this.deviceType = deviceType;
        this.installationDate = installationDate;
        this.status = status;
    }

    public Device(CreateDeviceCommand createDeviceCommand, DeviceType deviceType) {
        this();
        this.serialNumber = new SerialNumber(createDeviceCommand.serialNumber());
        this.model = new Model(createDeviceCommand.model());
        // this is a foreign key of DeviceType
        this.deviceType = deviceType;
        this.installationDate = new InstallationDate(createDeviceCommand.installationDate());
        this.status = new Status(createDeviceCommand.status());
    }

    //getters
    public String getSerialNumber() {
        return serialNumber.serialNumber();
    }
    public String getModel() {
        return model.model();
    }
    public LocalDate getInstallationDate() {
        return installationDate.installationDate();
    }
    public String getStatus() {
        return status.status();
    }
}
