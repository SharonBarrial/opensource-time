package org.hign.platform.u202120418.assessment.application.internal.commandservices;

import org.hign.platform.u202120418.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202120418.assessment.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.u202120418.assessment.domain.model.valueobjects.*;
import org.hign.platform.u202120418.assessment.domain.services.MentalStateExamCommandService;
import org.hign.platform.u202120418.assessment.infrastructure.persistence.jpa.repositories.MentalStateExamRepository;
import org.hign.platform.u202120418.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202120418.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import org.hign.platform.u202120418.personnel.infrastructure.persistence.jpa.repositories.ExaminerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * MentalStateExamCommandServiceImpl class definition and implementation
 *
 * @author Fiorella Jarama Peñaloza
 */
@Service
public class MentalStateExamCommandServiceImpl implements MentalStateExamCommandService {

    private final MentalStateExamRepository mentalStateExamRepository;
    private final ExaminerRepository examinerRepository;

    public MentalStateExamCommandServiceImpl(MentalStateExamRepository mentalStateExamRepository, ExaminerRepository examinerRepository) {
        this.mentalStateExamRepository = mentalStateExamRepository;
        this.examinerRepository = examinerRepository;
    }

    @Override
    public Optional<MentalStateExam> handle(CreateMentalStateExamCommand command) {
        // Obtener el NationalProviderIdentifier del comando
        String examinerNationalProviderIdentifier = command.examinerNationalProviderIdentifier();

        // Verificar si el examiner existe en el sistema
        Optional<Examiner> optionalExaminer = examinerRepository.findByNationalProviderIdentifier(new NationalProviderIdentifier(examinerNationalProviderIdentifier));
        if (optionalExaminer.isEmpty()) {
            throw new IllegalArgumentException("Examiner not found for provided NationalProviderIdentifier");
        }

        ExamDate examDate = new ExamDate(command.examDate());
        LanguageScore language = new LanguageScore(command.languageScore());
        OrientationScore orientation = new OrientationScore(command.orientationScore());
        PatientId patientId = new PatientId(command.patientId());
        RecallScore recall = new RecallScore(command.recallScore());
        RegistrationScore registration = new RegistrationScore(command.registrationScore());
        AttentionAndCalculationScore attentionAndCalculation = new AttentionAndCalculationScore(command.attentionAndCalculationScore());

        Examiner examiner = optionalExaminer.get();

        MentalStateExam mentalStateExam = new MentalStateExam(
                patientId, examDate, orientation, attentionAndCalculation, registration, recall, language, examiner
        );


        // Guardar el MentalStateExam en el repositorio
        MentalStateExam savedExam = mentalStateExamRepository.save(mentalStateExam);

        return Optional.of(savedExam);
    }
}
