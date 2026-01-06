package org.hign.platform.u202120418.personnel.interfaces.rest.transform;/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

import org.hign.platform.u202120418.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.u202120418.personnel.interfaces.rest.resources.CreateExaminerResource;

/**
 * CreateExaminerCommandFromResourceAssembler - Assembler for the command to create an examiner from a resource
 *
 * @author Fiorella Jarama Peñaloza
 */
public class CreateExaminerCommandFromResourceAssembler {
    /**
     * Transforms a CreateExaminerResource into a CreateExaminerCommand.
     * @param resource the CreateExaminerResource.
     * @return the CreateExaminerCommand.
     */
    public static CreateExaminerCommand toCommandFromResource(CreateExaminerResource resource){
        return new CreateExaminerCommand(
                resource.firstName(),
                resource.lastName(),
                resource.nationalProviderIdentifier());
    }
}
