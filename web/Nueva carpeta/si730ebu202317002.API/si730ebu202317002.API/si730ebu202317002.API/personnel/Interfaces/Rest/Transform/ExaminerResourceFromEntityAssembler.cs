using si730ebu202317002.API.personnel.Domain.Model.Aggregates;
using si730ebu202317002.API.personnel.Interfaces.Rest.Resources;

namespace si730ebu202317002.API.personnel.Interfaces.Rest.Transform;

public static class ExaminerResourceFromEntityAssembler
{
    public static ExaminerResource ToResourceFromEntity(Examiner entity)
    {
        return new ExaminerResource(
            entity.Id,
            entity.firstName,
            entity.lastName,
            entity.nationalProviderIdentifier
        );
    }
}