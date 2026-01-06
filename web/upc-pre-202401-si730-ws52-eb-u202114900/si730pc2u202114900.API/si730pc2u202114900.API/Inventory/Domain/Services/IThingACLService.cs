namespace si730pc2u202114900.API.Inventory.Domain.Services;

public interface IThingACLService
{
    Task<bool> ExistsSerialNumberAsync(Guid thingSerialNumber);
}
