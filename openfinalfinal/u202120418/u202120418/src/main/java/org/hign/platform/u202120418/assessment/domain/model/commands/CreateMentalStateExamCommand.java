package org.hign.platform.u202120418.assessment.domain.model.commands;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
public record CreateMentalStateExamCommand(
        Long patientId,
        String examDate,
        Integer orientationScore,
        Integer attentionAndCalculationScore,
        Integer registrationScore,
        Integer recallScore,
        Integer languageScore,
        String examinerNationalProviderIdentifier
) {
}
