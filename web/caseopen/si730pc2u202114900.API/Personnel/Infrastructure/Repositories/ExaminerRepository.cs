using Microsoft.EntityFrameworkCore;
using si730pc2u202114900.API.Personnel.Domain.Models.Entities;
using si730pc2u202114900.API.Personnel.Domain.Repositories;
using si730pc2u202114900.API.Shared.Infrastructure.Persistence.EFC.Configuration;
using si730pc2u202114900.API.Shared.Infrastructure.Persistence.EFC.Repositories;

namespace si730pc2u202114900.API.Personnel.Infrastructure.Repositories;

public class ExaminerRepository: BaseRepository<Examiner>, IExaminerRepository
{
    public ExaminerRepository(AppDbContext context) : base(context) {}

    public async Task<bool> ExistsExaminerWithNationalProviderIdentifierAsync(string nationalProviderIdentifier)
    {
        return await Context
            .Set<Examiner>()
            .AnyAsync(e => e.NationalProviderIdentifier == nationalProviderIdentifier);
    }
}