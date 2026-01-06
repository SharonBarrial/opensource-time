package io.travelers.platform.profiles.application.internal.queryservices;

import io.travelers.platform.profiles.domain.model.aggregates.Agency;
import io.travelers.platform.profiles.domain.model.queries.GetAgencyByIdQuery;
import io.travelers.platform.profiles.domain.model.queries.GetAllAgenciesQuery;
import io.travelers.platform.profiles.domain.services.AgencyQueryService;
import io.travelers.platform.profiles.infrastructure.persistence.jpa.repositories.AgencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyQueryServiceImpl implements AgencyQueryService {
    private final AgencyRepository agencyRepository;

    public AgencyQueryServiceImpl(AgencyRepository agencyRepository){
        this.agencyRepository = agencyRepository;
    }

    /**
     * Query handler to get agency by ID
     * @param query
     * @return Agency
     * @see Agency
     * @see GetAgencyByIdQuery
     * @author nombre
     */
    @Override
    public Optional<Agency> handle(GetAgencyByIdQuery query){
        return agencyRepository.findById(query.id());
    }

    /**
     * Query handler to get all agencies
     * @param query
     * @return List of Agencies
     * @see Agency
     * @see GetAllAgenciesQuery
     */
    @Override
    public List<Agency> handle(GetAllAgenciesQuery query){
        return agencyRepository.findAll();
    }
}
