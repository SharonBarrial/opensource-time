package org.hign.platform.u202120418.assessment.interfaces.rest.transform;/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

import org.hign.platform.u202120418.assessment.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.u202120418.assessment.interfaces.rest.resources.CreateMentalStateExamResource;

/**
 * Class that transforms a CreateMentalStateExamResource into a CreateMentalStateExamCommand.
 *
 * @author Fiorella Jarama Peñaloza
 */
public class CreateMentalStateExamCommandFromResourceAssembler {
    public static CreateMentalStateExamCommand toCommandFromResource(CreateMentalStateExamResource resource) {
        return new CreateMentalStateExamCommand(
                resource.patientId(),
                resource.examDate(),
                resource.orientationScore(),
                resource.attentionAndCalculationScore(),
                resource.registrationScore(),
                resource.recallScore(),
                resource.languageScore(),
                resource.examinerNationalProviderIdentifier()
        );
    }
}
