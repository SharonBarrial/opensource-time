using si730pc2u202114900.API.Personnel.Domain.Models.Commands;
using si730pc2u202114900.API.Personnel.Presentation.Rest.Resources;

namespace si730pc2u202114900.API.Personnel.Presentation.Rest.Transform;

public class CreateExaminerCommandFromResourceAssembler
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