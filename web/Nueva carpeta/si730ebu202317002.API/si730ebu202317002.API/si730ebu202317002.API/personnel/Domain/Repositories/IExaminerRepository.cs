using si730ebu202317002.API.personnel.Domain.Model.Aggregates;
using si730ebu202317002.API.Shared.Domain.Repositories;

namespace si730ebu202317002.API.personnel.Domain.Repositories;

public interface IExaminerRepository : IBaseRepository<Examiner>
{
    Task<bool> ExistsExaminerWithNationalProviderIdentifierAsync(Guid nationalProviderIdentifier);
}