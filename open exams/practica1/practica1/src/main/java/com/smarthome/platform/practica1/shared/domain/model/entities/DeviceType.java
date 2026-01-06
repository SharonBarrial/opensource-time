package com.smarthome.platform.practica1.shared.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DeviceType entity class
 * <p>
 *     Represents the type of a device.
 * </p>
 * @see AuditableModel
 * @author Salvador Salinas
 * @version 1.0
 */
@Entity
public class DeviceType extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // maximo 20 caracteres, único y obligatorio
    @NotNull
    @Size(max = 20)
    @Column(unique = true)
    private String type;

    public DeviceType() {}

    public DeviceType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
