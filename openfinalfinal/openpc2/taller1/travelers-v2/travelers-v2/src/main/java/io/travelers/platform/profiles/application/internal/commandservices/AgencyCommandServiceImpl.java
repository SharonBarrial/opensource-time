package io.travelers.platform.profiles.application.internal.commandservices;

import io.travelers.platform.profiles.domain.exceptions.BusinessNotFoundException;
import io.travelers.platform.profiles.domain.model.aggregates.Agency;
import io.travelers.platform.profiles.domain.model.commands.CreateAgencyCommand;
import io.travelers.platform.profiles.domain.model.entities.Business;
import io.travelers.platform.profiles.domain.model.valueobjects.AgencyName;
import io.travelers.platform.profiles.domain.model.valueobjects.Geolocation;
import io.travelers.platform.profiles.domain.model.valueobjects.StreetAddress;
import io.travelers.platform.profiles.domain.services.AgencyCommandService;
import io.travelers.platform.profiles.infrastructure.persistence.jpa.repositories.AgencyRepository;
import io.travelers.platform.profiles.infrastructure.persistence.jpa.repositories.BusinessRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgencyCommandServiceImpl implements AgencyCommandService {

    private final AgencyRepository agencyRepository;
    private final BusinessRepository businessRepository;

    public AgencyCommandServiceImpl(AgencyRepository agencyRepository, BusinessRepository businessRepository) {
        this.agencyRepository = agencyRepository;
        this.businessRepository = businessRepository;
    }

    @Override
    public Optional<Agency> handle(CreateAgencyCommand command){

        Business business = businessRepository.findById(command.businessId())
                .orElseThrow(() -> new BusinessNotFoundException(command.businessId()));

        var name = new AgencyName(command.name());
        agencyRepository.findByBusinessIdAndName(business, name).ifPresent(agency ->{
            throw new IllegalArgumentException("Agency with businessId and name already exists");
        });

        var geolocation = new Geolocation(command.latitude(), command.longitude());
        agencyRepository.findByGeolocation(geolocation).ifPresent(agency ->{
            throw new IllegalArgumentException("Agency with latitude and longitude already exists");
        });

        var streetAddress = new StreetAddress(command.street(), command.number(), command.city(), command.postalCode(), command.country());
        agencyRepository.findByAddress(streetAddress).ifPresent(agency -> {
            throw new IllegalArgumentException("Agency with street address already exists");
        });

        var agency = new Agency(command, business);
        agencyRepository.save(agency);
        return Optional.of(agency);
    }
}
