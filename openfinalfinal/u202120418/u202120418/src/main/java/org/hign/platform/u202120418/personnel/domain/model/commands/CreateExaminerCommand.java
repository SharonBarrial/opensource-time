package org.hign.platform.u202120418.personnel.domain.model.commands;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
public record CreateExaminerCommand(
        String firstName,
        String lastName,
        String nationalProviderIdentifier
) {
}
