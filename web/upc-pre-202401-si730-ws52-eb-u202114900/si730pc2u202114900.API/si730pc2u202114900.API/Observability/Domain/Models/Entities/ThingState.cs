using si730pc2u202114900.API.Inventory.Domain.Models.Entities;
using si730pc2u202114900.API.Observability.Domain.Models.Commands;

namespace si730pc2u202114900.API.Observability.Domain.Models.Entities;

public class ThingState : ThingAudit
{
    public int Id { get; set; }
    public Guid ThingSerialNumber { get; set; }
    public int CurrentOperationMode { get; set; }
    public decimal CurrentTemperature { get; set; }
    public decimal CurrentHumidity { get; set; }
    public DateTime CollectedAt { get; set; } 
    
    
    public ThingState() {}
    
    public ThingState(CreateThingStateCommand command)
    {
        ThingSerialNumber = command.ThingSerialNumber;
        CurrentOperationMode = command.CurrentOperationMode;
        CurrentTemperature = command.CurrentTemperature;
        CurrentHumidity = command.CurrentHumidity;
        CollectedAt = command.CollectedAt;
    }
}