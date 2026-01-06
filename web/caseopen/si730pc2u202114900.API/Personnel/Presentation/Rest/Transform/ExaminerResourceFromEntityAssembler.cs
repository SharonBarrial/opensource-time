using si730pc2u202114900.API.Personnel.Domain.Models.Entities;
using si730pc2u202114900.API.Personnel.Presentation.Rest.Resources;

namespace si730pc2u202114900.API.Personnel.Presentation.Rest.Transform;

public class ExaminerResourceFromEntityAssembler
{
    public static ExaminerResource ToResourceFromEntity(Examiner entity)
    {
        return new ExaminerResource(
            entity.Id,
            entity.FirstName,
            entity.LastName,
            entity.NationalProviderIdentifier
        );
    }
}