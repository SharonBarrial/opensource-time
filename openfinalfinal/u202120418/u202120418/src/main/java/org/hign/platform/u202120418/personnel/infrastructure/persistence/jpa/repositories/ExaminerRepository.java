package org.hign.platform.u202120418.personnel.infrastructure.persistence.jpa.repositories;

import org.hign.platform.u202120418.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202120418.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * ExaminerRepository - Repository for Examiner
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
@Repository
public interface ExaminerRepository extends JpaRepository<Examiner, Long> {
    boolean existsByNationalProviderIdentifier(NationalProviderIdentifier nationalProviderIdentifier);
    Optional<Examiner> findByNationalProviderIdentifier(NationalProviderIdentifier examinerNationalProviderIdentifier);
}
