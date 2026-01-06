namespace si730pc2u202114900.API.Observability.Presentation.Rest.Resources;

public record ThingStateResource(
    int Id,
    Guid ThingSerialNumber,
    int CurrentOperationMode,
    decimal CurrentTemperature,
    decimal CurrentHumidity,
    DateTime CollectedAt);