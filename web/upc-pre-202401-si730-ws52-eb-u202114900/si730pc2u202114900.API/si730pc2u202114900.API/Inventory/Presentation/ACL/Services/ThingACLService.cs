using si730pc2u202114900.API.Inventory.Domain.Repositories;
using si730pc2u202114900.API.Inventory.Domain.Services;
namespace si730pc2u202114900.API.Inventory.Presentation.ACL.Services;

public class ThingACLService : IThingACLService
{
    private readonly IThingRepository _thingRepository;
    
    public ThingACLService(IThingRepository thingRepository)
    {
        _thingRepository = thingRepository;
    }

    public Task<bool> ExistsSerialNumberAsync(Guid thingSerialNumber)
    {
        return _thingRepository.ExistsThingWithSerialNumberAsync(thingSerialNumber);
    }
}