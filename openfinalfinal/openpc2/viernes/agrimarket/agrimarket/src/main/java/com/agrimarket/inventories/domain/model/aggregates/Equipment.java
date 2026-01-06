package com.agrimarket.inventories.domain.model.aggregates;

import com.agrimarket.inventories.domain.model.commands.CreateEquipmentCommand;
import com.agrimarket.inventories.domain.model.entities.CategoryType;
import com.agrimarket.inventories.domain.model.valueobjects.Description;
import com.agrimarket.inventories.domain.model.valueobjects.Name;
import com.agrimarket.inventories.domain.model.valueobjects.ReferenceImageUrl;
import com.agrimarket.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * Equipment Aggregate Root
 * @author Sharon Antuanet Ivet Barrial Marin
 * @version 1.0
 */

@Getter
@Setter
@Entity
public class Equipment extends AuditableAbstractAggregateRoot<Equipment> {
    @Embedded
    private Name name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryType categoryType;

    @Embedded
    private Description description;

    @Embedded
    private ReferenceImageUrl referenceImageUrl;

    public Equipment() {}

    /**
     * Constructor
     * @param name Equipment name
     * @param categoryType Equipment category type
     * @param description Equipment description
     * @param referenceImageUrl Equipment reference image URL
     */

    public Equipment(Name name, CategoryType categoryType, Description description, ReferenceImageUrl referenceImageUrl) {
        this();
        this.name = name;
        // this is a foreign key of CategoryType
        this.categoryType = categoryType;
        this.description = description;
        this.referenceImageUrl = referenceImageUrl;

    }

    /**
     * Constructor
     * @param command CreateEquipmentCommand
     * @param categoryType Equipment group type
     */

    public Equipment(CreateEquipmentCommand command, CategoryType categoryType){
        this();
        this.name = new Name(command.name());
        // this is a foreign key of SensorType
        this.categoryType = categoryType;
        this.description = new Description(command.description());
        this.referenceImageUrl = new ReferenceImageUrl(command.referenceImageUrl());
    }

    //Getters
    public String getName() {
        return name.name();
    }
    public String getDescription() {
        return description.description();
    }
    public String getReferenceImageUrl() {
        return referenceImageUrl.referenceImageUrl();
    }


}
