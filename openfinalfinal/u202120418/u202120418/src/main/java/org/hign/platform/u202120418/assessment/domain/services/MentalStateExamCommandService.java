package org.hign.platform.u202120418.assessment.domain.services;

import org.hign.platform.u202120418.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202120418.assessment.domain.model.commands.CreateMentalStateExamCommand;

import java.util.Optional;

/**
 * Commands service for mental state exam
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
public interface MentalStateExamCommandService {
    Optional<MentalStateExam> handle(CreateMentalStateExamCommand command);
}
