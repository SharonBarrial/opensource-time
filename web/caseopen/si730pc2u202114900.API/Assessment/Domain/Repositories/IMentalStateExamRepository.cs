using si730pc2u202114900.API.Assessment.Domain.Models.Entities;
using si730pc2u202114900.API.Shared.Domain.Repositories;

namespace si730pc2u202114900.API.Assessment.Domain.Repositories;

/**
 * <summary>
 * Represents the repository interface for the MentalStateExam entity. This interface extends the IBaseRepository interface with a method for checking the existence of an examiner.
 * </summary>
 * <author>
 * Sharon Antuanet Ivet Barrial Marin
 * - Code Student: u202114900
 * </author>
 * <version>1.0.0</version>
 */
public interface IMentalStateExamRepository : IBaseRepository<MentalStateExam>
{
    /**
     * <summary>
     * Checks if an examiner exists based on their national provider identifier.
     * </summary>
     * <param name="examinerNationalProviderIdentifier">The national provider identifier of the examiner.</param>
     * <returns>A task that represents the asynchronous operation. The task result contains a boolean indicating whether the examiner exists.</returns>
     */
    Task<bool> ExistsExaminerAsync(string examinerNationalProviderIdentifier);
}