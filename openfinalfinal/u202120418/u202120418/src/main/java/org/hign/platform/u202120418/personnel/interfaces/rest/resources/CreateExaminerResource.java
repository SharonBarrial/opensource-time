package org.hign.platform.u202120418.personnel.interfaces.rest.resources;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
public record CreateExaminerResource(
        String firstName,
        String lastName,
        String nationalProviderIdentifier
) {
}
