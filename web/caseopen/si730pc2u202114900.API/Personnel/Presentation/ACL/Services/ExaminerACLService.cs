using si730pc2u202114900.API.Personnel.Domain.Repositories;
using si730pc2u202114900.API.Personnel.Domain.Services;

namespace si730pc2u202114900.API.Personnel.Presentation.ACL.Services;

public class ExaminerACLService : IExaminerACLService
{
    private readonly IExaminerRepository _examinerRepository;
    
    public ExaminerACLService(IExaminerRepository examinerRepository)
    {
        _examinerRepository = examinerRepository;
    }
    
    public Task<bool> ExistsExaminerAsync(string examinerNationalProviderIdentifier)
    {
        return _examinerRepository.ExistsExaminerWithNationalProviderIdentifierAsync(examinerNationalProviderIdentifier);
    }

    
}