package io.travelers.platform.profiles.domain.services;

import io.travelers.platform.profiles.domain.model.aggregates.Agency;
import io.travelers.platform.profiles.domain.model.commands.CreateAgencyCommand;

import java.util.Optional;

public interface AgencyCommandService {
    Optional<Agency> handle(CreateAgencyCommand command);
}
