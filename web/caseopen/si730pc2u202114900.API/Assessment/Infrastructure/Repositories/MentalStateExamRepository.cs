using Microsoft.EntityFrameworkCore;
using si730pc2u202114900.API.Assessment.Domain.Models.Entities;
using si730pc2u202114900.API.Assessment.Domain.Repositories;
using si730pc2u202114900.API.Personnel.Domain.Models.Entities;
using si730pc2u202114900.API.Shared.Infrastructure.Persistence.EFC.Configuration;
using si730pc2u202114900.API.Shared.Infrastructure.Persistence.EFC.Repositories;

namespace si730pc2u202114900.API.Assessment.Infrastructure.Repositories;

/**
 * <summary>
 * Represents the repository for the MentalStateExam entity. This class extends the BaseRepository class and implements the IMentalStateExamRepository interface.
 * It contains a constructor for initializing the repository with a database context and a method for checking the existence of an examiner.
 * </summary>
 * <author>
 * Sharon Antuanet Ivet Barrial Marin
 * - Code Student: u202114900
 * </author>
 * <version>1.0.0</version>
 */
public class MentalStateExamRepository : BaseRepository<MentalStateExam>, IMentalStateExamRepository
{
    /**
     * <summary>
     * Initializes a new instance of the MentalStateExamRepository class with the provided database context.
     * </summary>
     * <param name="context">The database context.</param>
     */
    public MentalStateExamRepository(AppDbContext context) : base(context) { }
    
    /**
     * <summary>
     * Checks if an examiner exists based on their national provider identifier.
     * </summary>
     * <param name="examinerNationalProviderIdentifier">The national provider identifier of the examiner.</param>
     * <returns>A task that represents the asynchronous operation. The task result contains a boolean indicating whether the examiner exists.</returns>
     */
    
    public async Task<bool> ExistsExaminerAsync(string examinerNationalProviderIdentifier)
    {
        return await Context.Set<Examiner>().AnyAsync(e => e.NationalProviderIdentifier == examinerNationalProviderIdentifier);
    }

    
}