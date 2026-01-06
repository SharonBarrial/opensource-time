package org.hign.platform.u202120418.personnel.interfaces.rest.transform;/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

import org.hign.platform.u202120418.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202120418.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.u202120418.personnel.interfaces.rest.resources.CreateExaminerResource;
import org.hign.platform.u202120418.personnel.interfaces.rest.resources.ExaminerResource;

/**
 * ExaminerResourceFromEntityAssembler - Assembler for the command to create an examiner from a resource
 *
 * @author Fiorella Jarama Peñaloza
 */
public class ExaminerResourceFromEntityAssembler {
    /**
     * Transforms a CreateExaminerResource into a CreateExaminerCommand.
     * @param entity the CreateExaminerResource.
     * @return the CreateExaminerCommand.
     */
    public static ExaminerResource toResourceFromEntity(Examiner entity){
        return new ExaminerResource(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getNationalProviderIdentifier());
    }
}
