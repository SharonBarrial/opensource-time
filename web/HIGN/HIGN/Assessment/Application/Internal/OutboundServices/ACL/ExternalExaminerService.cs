
using HIGN.Assessment.Domain.Model.ValueObjects;
using HIGN.Personnel.Interfaces.ACL;

namespace HIGN.Assessment.Application.Internal.OutboundServices.ACL;

public class ExternalExaminerService(IExaminerContextFacade examinerContextFacade)
{
    public async Task<ExaminerId?> FetchExaminerById(long id)
    {
        var examinerId = await  examinerContextFacade.FetchExaminerIdAsync(id);
        return new ExaminerId(examinerId);
    }
}