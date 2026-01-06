using HIGN.Personnel.Domain.Model.Aggregates;
using HIGN.Personnel.Domain.Repositories;
using HIGN.Personnel.Domain.Services;

namespace HIGN.Personnel.Application.Internal.QueryServices;

public class ExaminerQueryService(IExaminerRepository examinerRepository) : IExaminerQueryService
{
    public async Task<Examiner?> GetExaminerByIdAsync(long id)
    {
        return await examinerRepository.FindByIdAsync(id);
    }
}