namespace si730ebu20221c936.Inventory.Domain.Model.Command;

public record CreateThingCommand(Guid SerialNumber, string Model, int OperationMode, double MaximumTemperatureThreshold, double MinimumHumidityThreshold);