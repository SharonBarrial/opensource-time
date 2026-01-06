package org.hign.platform.u202120418.personnel.application.internal.commandservices;/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

import org.hign.platform.u202120418.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202120418.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.u202120418.personnel.domain.model.valueobjects.FirstName;
import org.hign.platform.u202120418.personnel.domain.model.valueobjects.LastName;
import org.hign.platform.u202120418.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import org.hign.platform.u202120418.personnel.domain.services.ExaminerCommandService;
import org.hign.platform.u202120418.personnel.infrastructure.persistence.jpa.repositories.ExaminerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ExaminerCommandServicesImpl - Implementation of ExaminerCommandService
 *
 * @author Fiorella Jarama Peñaloza
 */
@Service
public class ExaminerCommandServicesImpl implements ExaminerCommandService {

    private final ExaminerRepository examinerRepository;

    public ExaminerCommandServicesImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    @Override
    public Optional<Examiner> handle(CreateExaminerCommand command) {
        NationalProviderIdentifier npi = new NationalProviderIdentifier(command.nationalProviderIdentifier());

        FirstName firstName = new FirstName(command.firstName());
        LastName lastName = new LastName(command.lastName());

        if (examinerRepository.existsByNationalProviderIdentifier(npi)) {
            throw new IllegalArgumentException("Examiner with given National Provider Identifier already exists");
        }

        Examiner examiner = new Examiner(
                firstName,
                lastName,
                npi
        );

        examiner = examinerRepository.save(examiner);

        return Optional.of(examiner);
    }
}
