using si730pc2u202114900.API.Shared;

namespace si730pc2u202114900.API.Inventory.Presentation.Rest.Resource;

/// <summary>
/// Represents the resource for a Thing.
/// </summary>
public record ThingResource(
    int Id,
    Guid SerialNumber,
    string Model,
    EnumOperationMode.EOperationMode OperationMode,
    decimal MaximumTemperatureThreshold,
    decimal MinimumHumidityThreshold
    );