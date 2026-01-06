using Microsoft.EntityFrameworkCore;
using si730pc2u202114900.API.Inventory.Domain.Models.Entities;
using si730pc2u202114900.API.Inventory.Domain.Repositories;
using si730pc2u202114900.API.Shared;
using si730pc2u202114900.API.Shared.Infrastructure.Persistence.EFC.Configuration;
using si730pc2u202114900.API.Shared.Infrastructure.Persistence.EFC.Repositories;

namespace si730pc2u202114900.API.Inventory.Infrastructure.Repositories;

/**
 * <summary>
 * Represents the repository for the Thing entity. This class extends the BaseRepository class and implements the IThingRepository interface.
 * It contains a constructor for initializing the repository with a database context and a method for checking the existence of an examiner.
 * </summary>
 * <author>
 * Sharon Antuanet Ivet Barrial Marin
 * - Code Student: u202114900
 * </author>
 * <version>1.0.0</version>
 */
public class ThingRepository : BaseRepository<Thing>, IThingRepository
{
    /**
     * <summary>
     * Initializes a new instance of the ThingRepository class with the provided database context.
     * </summary>
     * <param name="context">The database context.</param>
     */
    public ThingRepository(AppDbContext context) : base(context) { }
    
    /**
     * <summary>
     * Checks if an examiner exists based on their national provider identifier.
     * </summary>
     * <param name="serialNumber">The national provider identifier of the examiner.</param>
     * <returns>A task that represents the asynchronous operation. The task result contains a boolean indicating whether the examiner exists.</returns>
     */
   public async Task<bool> ExistsThingWithSerialNumberAsync(Guid serialNumber) 
    {
    return await Context.Set<Thing>().AnyAsync(e => e.SerialNumber == serialNumber); 
    }
    
    public async Task<Thing?> FindById(int id)
    {
        return await Context.Set<Thing>().FirstOrDefaultAsync(e => e.Id == id);
    }
    
    public async Task<Thing?> FindByOperationMode(string operationMode)
{
    if (Enum.TryParse(typeof(EnumOperationMode.EOperationMode), operationMode, out var parsedOperationMode))
    {
        return await Context.Set<Thing>().FirstOrDefaultAsync(e => e.OperationMode == (EnumOperationMode.EOperationMode)parsedOperationMode);
    }
    else
    {
        throw new ArgumentException($"Invalid operation mode: {operationMode}");
    }
}

}