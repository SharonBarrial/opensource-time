package com.smarthome.platform.practica1.analytics.domain.model.aggregates;

import com.smarthome.platform.practica1.analytics.domain.model.valueobjects.Description;
import com.smarthome.platform.practica1.analytics.domain.model.valueobjects.MaxValue;
import com.smarthome.platform.practica1.analytics.domain.model.valueobjects.MinValue;
import com.smarthome.platform.practica1.analytics.domain.model.valueobjects.Name;
import com.smarthome.platform.practica1.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.smarthome.platform.practica1.shared.domain.model.entities.DeviceType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

/**
 * Performance Indicator Entity
 * <p>
 *     Represents a Performance Indicator entity.
 *     A Performance Indicator is a measure of the performance of a device.
 * </p>
 * @see AuditableAbstractAggregateRoot
 * @author Salvador Salinas
 * @version 1.0
 */
@Entity
public class PerformanceIndicator extends AuditableAbstractAggregateRoot<PerformanceIndicator> {
    @Embedded
    @NotNull(message = "Name is required")
    private Name name;

    @Embedded
    @NotNull(message = "Description is required")
    private Description description;

    @Embedded
    @NotNull(message = "Minimum value is required")
    private MinValue minValue;

    @Embedded
    @NotNull(message = "Maximum value is required")
    private MaxValue maxValue;

    @ManyToOne
    @JoinColumn(nullable = false, name = "device_type_id")
    private DeviceType deviceType;

    public PerformanceIndicator() {}

    public PerformanceIndicator(Name name, Description description, MinValue minValue, MaxValue maxValue, DeviceType deviceType) {
        this.name = name;
        this.description = description;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.deviceType = deviceType;
    }

    public String getName() {
        return name.name();
    }

    public String getDescription() {
        return description.description();
    }

    public Double getMaxValue() {
        return maxValue.maxValue();
    }

    public Double getMinValue() {
        return minValue.minValue();
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }
}
