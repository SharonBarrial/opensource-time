using HIGN.Personnel.Domain.Model.Aggregates;
using HIGN.Shared.Domain.Repositories;

namespace HIGN.Personnel.Domain.Repositories;

public interface IExaminerRepository : IBaseRepository<Examiner>
{
    bool ExistsByNationalProviderIdentifier(string nationalProviderIdentifier);
}