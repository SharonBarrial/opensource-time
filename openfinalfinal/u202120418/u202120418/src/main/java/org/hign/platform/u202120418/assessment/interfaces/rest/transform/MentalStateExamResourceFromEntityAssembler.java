package org.hign.platform.u202120418.assessment.interfaces.rest.transform;/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

import org.hign.platform.u202120418.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202120418.assessment.interfaces.rest.resources.MentalStateExamResource;

/**
 * Class that transforms a MentalStateExam entity into a MentalStateExamResource.
 *
 * @author Fiorella Jarama Peñaloza
 */
public class MentalStateExamResourceFromEntityAssembler {
    public static MentalStateExamResource toResourceFromEntity(MentalStateExam entity) {
        return new MentalStateExamResource(
                entity.getId(),
                entity.getPatientId(),
                entity.getExamDate(),
                entity.getOrientationScore(),
                entity.getAttentionAndCalculationScore(),
                entity.getRegistrationScore(),
                entity.getRecallScore(),
                entity.getLanguageScore(),
                entity.getExaminer()
        );
    }
}
