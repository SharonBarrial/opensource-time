using Microsoft.EntityFrameworkCore;
using si730ebu202317002.API.assessment.Domain.Model.Aggregates;
using si730ebu202317002.API.assessment.Domain.Repositories;
using si730ebu202317002.API.personnel.Domain.Model.Aggregates;
using si730ebu202317002.API.Shared.Infrastructure.Persistence.EFC.Configuration;
using si730ebu202317002.API.Shared.Infrastructure.Persistence.EFC.Repositories;

namespace si730ebu202317002.API.assessment.Infrastructure.Persitence.EFC.Repositories;

public class MentalStateExamRepository : BaseRepository<MentalStateExam>, IMentalStateExamRepository
{
    public MentalStateExamRepository(AppDbContext context) : base(context) { }

    public async Task<bool> ExistsExaminerAsync(Guid examinerNationalProviderIdentifier)
    {
        // Assuming there's a DbSet<Examiner> in the AppDbContext
        return await Context.Set<Examiner>().AnyAsync(e => e.nationalProviderIdentifier == examinerNationalProviderIdentifier);
    }
}