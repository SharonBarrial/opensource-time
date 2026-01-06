using si730pc2u202114900.API.Inventory.Domain.Models.Entities;
using si730pc2u202114900.API.Shared.Domain.Repositories;

namespace si730pc2u202114900.API.Inventory.Domain.Repositories;

/**
 * <summary>
 * Represents the repository interface for the Thing entity. This interface extends the IBaseRepository interface with a method for checking the existence of an examiner.
 * </summary>
 * <author>
 * Sharon Antuanet Ivet Barrial Marin
 * - Code Student: u202114900
 * </author>
 * <version>1.0.0</version>
 */
public interface IThingRepository : IBaseRepository<Thing>
{
    /**
     * <summary>
     * Checks if a Thing exists based on its serial number.
     * </summary>
     * <param name="serialNumber">The serial number of the Thing.</param>
     * <returns>A task that represents the asynchronous operation. The task result contains a boolean indicating whether the Thing exists.</returns>
     */
    Task<bool> ExistsThingWithSerialNumberAsync(Guid serialNumber);
    Task<Thing?> FindById(int id);
    Task<Thing?> FindByOperationMode(string operationMode);
}