package org.hign.platform.u202120418.personnel.domain.services;

import org.hign.platform.u202120418.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202120418.personnel.domain.model.commands.CreateExaminerCommand;

import java.util.Optional;

/**
 * Commands service for examiner
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
public interface ExaminerCommandService {
    Optional<Examiner> handle(CreateExaminerCommand command);
}
