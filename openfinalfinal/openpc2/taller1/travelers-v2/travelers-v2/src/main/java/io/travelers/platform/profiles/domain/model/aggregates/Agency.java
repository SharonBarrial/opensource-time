package io.travelers.platform.profiles.domain.model.aggregates;

import io.travelers.platform.profiles.domain.model.commands.CreateAgencyCommand;
import io.travelers.platform.profiles.domain.model.entities.Business;
import io.travelers.platform.profiles.domain.model.valueobjects.AgencyName;
import io.travelers.platform.profiles.domain.model.valueobjects.Geolocation;
import io.travelers.platform.profiles.domain.model.valueobjects.StreetAddress;
import io.travelers.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

/**
 * Represents an agency in the system. This entity is auditable and inherits
 * auditing fields from {@link AuditableAbstractAggregateRoot}.
 *
 * @author Nombre Apellido
 *
 */
@Entity
public class Agency extends AuditableAbstractAggregateRoot<Agency> {

    @Embedded
    @NotNull(message="Name is mandatory")
    private AgencyName name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="street", column=@Column(name =" address_street")),
            @AttributeOverride(name="number", column=@Column(name =" address_number")),
            @AttributeOverride(name="city", column=@Column(name =" address_city")),
            @AttributeOverride(name="postalCode", column=@Column(name =" address_postal_code")),
            @AttributeOverride(name="country", column=@Column(name =" address_country")),})
    @NotNull(message="Street address is mandatory")
    private StreetAddress address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="latitude", column=@Column(name =" latitude")),
            @AttributeOverride(name="longitude", column=@Column(name =" longitude"))})
    private Geolocation geolocation;

    @ManyToOne
    @JoinColumn(name = "business_id")
    @NotNull(message = "BusinessId is mandatory")
    private Business businessId;

    public Agency(CreateAgencyCommand command, Business business){
        this.businessId = business;
        this.name = new AgencyName(command.name());
        this.address = new StreetAddress(command.street(), command.number(), command.city(), command.postalCode(), command.country());
        this.geolocation = new Geolocation(command.latitude(), command.longitude());
    }

    public Agency(){
    }

    public Long getBusinessId(){
        return businessId.getId();
    }
    public String getName(){
        return name.getAgencyName();
    }
    public String getStreetAddress(){
        return address.getStreetAddress();
    }
    public String getGeolocation(){
        return geolocation.getGeolocation();
    }
}
