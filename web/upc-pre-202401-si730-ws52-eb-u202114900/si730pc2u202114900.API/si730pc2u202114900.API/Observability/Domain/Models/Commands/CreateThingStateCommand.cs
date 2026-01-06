namespace si730pc2u202114900.API.Observability.Domain.Models.Commands;

public record CreateThingStateCommand(
    Guid ThingSerialNumber,
    int CurrentOperationMode,
    decimal CurrentTemperature,
    decimal CurrentHumidity,
    DateTime CollectedAt
    );