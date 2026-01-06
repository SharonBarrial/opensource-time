using si730pc2u202114900.API.Personnel.Domain.Models.Entities;
using si730pc2u202114900.API.Shared.Domain.Repositories;

namespace si730pc2u202114900.API.Personnel.Domain.Repositories;

public interface IExaminerRepository: IBaseRepository<Examiner>
{
    Task<bool> ExistsExaminerWithNationalProviderIdentifierAsync(string nationalProviderIdentifier);
}