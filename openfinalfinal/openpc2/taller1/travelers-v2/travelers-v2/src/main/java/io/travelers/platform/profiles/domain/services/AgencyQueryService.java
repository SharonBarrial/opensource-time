package io.travelers.platform.profiles.domain.services;

import io.travelers.platform.profiles.domain.model.aggregates.Agency;
import io.travelers.platform.profiles.domain.model.queries.GetAgencyByIdQuery;
import io.travelers.platform.profiles.domain.model.queries.GetAllAgenciesQuery;

import java.util.List;
import java.util.Optional;

public interface AgencyQueryService {
    Optional<Agency> handle(GetAgencyByIdQuery query);
    List<Agency> handle(GetAllAgenciesQuery query);
}
