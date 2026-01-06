using si730ebu202317002.API.personnel.Domain.Model.Commands;
using si730ebu202317002.API.personnel.Interfaces.Rest.Resources;

namespace si730ebu202317002.API.personnel.Interfaces.Rest.Transform;

public static class CreateExaminerCommandFromResourceAssembler
{
    public static CreateExaminerCommand ToCommandFromResource(CreateExaminerResource resource)
    {
        return new CreateExaminerCommand(
            resource.FirstName, 
            resource.LastName,
            resource.NationalProviderIdentifier
        );
    }
}