using Microsoft.EntityFrameworkCore;
using si730pc2u202114900.API.Inventory.Domain.Models.Entities;
using si730pc2u202114900.API.Inventory.Domain.Repositories;
using si730pc2u202114900.API.Observability.Domain.Models.Entities;
using si730pc2u202114900.API.Observability.Domain.Repositories;
using si730pc2u202114900.API.Shared.Infrastructure.Persistence.EFC.Configuration;
using si730pc2u202114900.API.Shared.Infrastructure.Persistence.EFC.Repositories;

namespace si730pc2u202114900.API.Observability.Infrastructure.Repositories;

public class ThingStateRepository: BaseRepository<ThingState>, IThingStateRepository
{
    private IThingRepository _thingRepositoryImplementation;
    public ThingStateRepository(AppDbContext context) : base(context) {}
    public async Task<bool> ExistsThingWithSerialNumberAsync(Guid serialNumber)
    {
        return await Context
            .Set<ThingState>()
            .AnyAsync(e => e.ThingSerialNumber == serialNumber);
    }
    
}