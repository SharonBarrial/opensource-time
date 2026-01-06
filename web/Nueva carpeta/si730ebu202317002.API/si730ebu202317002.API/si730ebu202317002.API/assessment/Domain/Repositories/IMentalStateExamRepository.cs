using si730ebu202317002.API.assessment.Domain.Model.Aggregates;
using si730ebu202317002.API.Shared.Domain.Repositories;

namespace si730ebu202317002.API.assessment.Domain.Repositories;

public interface IMentalStateExamRepository : IBaseRepository<MentalStateExam>
{
    Task<bool> ExistsExaminerAsync(Guid examinerNationalProviderIdentifier);
}