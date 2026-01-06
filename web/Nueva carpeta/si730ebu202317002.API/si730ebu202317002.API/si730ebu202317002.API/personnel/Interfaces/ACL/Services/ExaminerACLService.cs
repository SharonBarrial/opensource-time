using si730ebu202317002.API.personnel.Domain.Repositories;
using si730ebu202317002.API.personnel.Domain.Services;

namespace si730ebu202317002.API.personnel.Interfaces.ACL.Services;

public class ExaminerACLService : IExaminerACLService
{
    private readonly IExaminerRepository _examinerRepository;

    public ExaminerACLService(IExaminerRepository examinerRepository)
    {
        _examinerRepository = examinerRepository;
    }

    public async Task<bool> ExistsExaminerAsync(Guid examinerNationalProviderIdentifier)
    {
        return await _examinerRepository.ExistsExaminerWithNationalProviderIdentifierAsync(examinerNationalProviderIdentifier);
    }
}