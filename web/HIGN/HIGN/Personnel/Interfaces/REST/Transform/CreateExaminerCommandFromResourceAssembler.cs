using HIGN.Personnel.Domain.Model.Commands;
using HIGN.Personnel.Interfaces.REST.Resources;

namespace HIGN.Personnel.Interfaces.REST.Transform;

public class CreateExaminerCommandFromResourceAssembler
{
    public static CreateExaminerCommand ToCommandFromResource(CreateExaminerResource resource)
    {
        return new CreateExaminerCommand(resource.FirstName, resource.LastName, resource.NationalProviderIdentifier);
    }
}