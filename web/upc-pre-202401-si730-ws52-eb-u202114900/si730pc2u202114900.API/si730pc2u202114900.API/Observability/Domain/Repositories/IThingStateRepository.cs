using si730pc2u202114900.API.Observability.Domain.Models.Entities;
using si730pc2u202114900.API.Shared.Domain.Repositories;

namespace si730pc2u202114900.API.Observability.Domain.Repositories;

public interface IThingStateRepository: IBaseRepository<ThingState>
{
    Task<bool> ExistsThingWithSerialNumberAsync(Guid serialNumber);
}