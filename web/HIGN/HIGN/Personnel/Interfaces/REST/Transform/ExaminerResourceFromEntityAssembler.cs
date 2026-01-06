using HIGN.Personnel.Domain.Model.Aggregates;
using HIGN.Personnel.Interfaces.REST.Resources;

namespace HIGN.Personnel.Interfaces.REST.Transform;

public class ExaminerResourceFromEntityAssembler
{
    public static ExaminerResource ToResourceFromEntity(Examiner examiner)
    {
        return new ExaminerResource(examiner.Id, examiner.FirstName, examiner.LastName,
            examiner.NationalProviderIdentifier);
    }
}