using si730ebu20221c936.Inventory.Domain.Model.Aggregates;

namespace si730ebu20221c936.Inventory.Domain.Repositories;

public interface IThingRepository
{
    Task<Thing?> FindById(int id);
    Task<Thing?> FindBySerialNumber(Guid serialNumber);
    Task<Thing?> FindByOperationMode(string operationMode);
}