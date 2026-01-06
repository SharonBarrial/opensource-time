package org.hign.platform.u202120418.assessment.interfaces.rest.resources;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
public record MentalStateExamResource(
        Long id,
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
