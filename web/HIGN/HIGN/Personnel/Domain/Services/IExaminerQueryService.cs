using HIGN.Personnel.Domain.Model.Aggregates;

namespace HIGN.Personnel.Domain.Services;

public interface IExaminerQueryService
{
    Task<Examiner?> GetExaminerByIdAsync(long id);
}