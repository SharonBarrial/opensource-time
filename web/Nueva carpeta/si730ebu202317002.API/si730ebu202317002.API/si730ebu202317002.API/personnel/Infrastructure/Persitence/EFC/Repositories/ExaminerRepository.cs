using Microsoft.EntityFrameworkCore;
using si730ebu202317002.API.personnel.Domain.Model.Aggregates;
using si730ebu202317002.API.personnel.Domain.Repositories;
using si730ebu202317002.API.Shared.Infrastructure.Persistence.EFC.Configuration;
using si730ebu202317002.API.Shared.Infrastructure.Persistence.EFC.Repositories;

namespace si730ebu202317002.API.personnel.Infrastructure.Persitence.EFC.Repositories;



public class ExaminerRepository : BaseRepository<Examiner>, IExaminerRepository
{
    public ExaminerRepository(AppDbContext context) : base(context) {}

    public async Task<bool> ExistsExaminerWithNationalProviderIdentifierAsync(Guid nationalProviderIdentifier)
    {
        return await Context.Set<Examiner>()
            .AnyAsync(e => e.nationalProviderIdentifier == nationalProviderIdentifier);
    }
}