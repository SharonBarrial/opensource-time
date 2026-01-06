package org.hign.platform.u202120418.assessment.infrastructure.persistence.jpa.repositories;

import org.hign.platform.u202120418.assessment.domain.model.aggregates.MentalStateExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
@Repository
public interface MentalStateExamRepository extends JpaRepository<MentalStateExam, Long> {
}
