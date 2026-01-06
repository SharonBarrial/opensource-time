using HIGN.Personnel.Domain.Model.Aggregates;
using HIGN.Personnel.Domain.Repositories;
using HIGN.Shared.Infrastructure.Persistence.EFC.Configuration;
using HIGN.Shared.Infrastructure.Persistence.EFC.Repositories;

namespace HIGN.Personnel.Infrastructure.Persistence.EFC.Repositories;

public class ExaminerRepository(AppDbContext context) : BaseRepository<Examiner>(context), IExaminerRepository
{
    public bool ExistsByNationalProviderIdentifier(string nationalProviderIdentifier)
    {
        return context.Set<Examiner>().AsEnumerable().Any(examiner => examiner.NationalProviderIdentifier == nationalProviderIdentifier);
    }
}