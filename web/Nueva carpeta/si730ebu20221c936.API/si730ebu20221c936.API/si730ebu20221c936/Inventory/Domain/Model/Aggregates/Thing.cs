using si730ebu20221c936.Inventory.Domain.Model.Command;
using si730ebu20221c936.Inventory.Domain.Model.ValueObjects;
using si730ebu20221c936.Shared.Domain.Model.ValueObjects;

namespace si730ebu20221c936.Inventory.Domain.Model.Aggregates;

public partial class Thing
{
    // Properties
    public int Id { get; private set; }
    public SerialNumber SerialNumber { get; private set; }
    public string Model { get; private set; }
    public EOperationMode OperationMode { get; private set; }
    public double MaximumTemperatureThreshold { get; private set; }
    public double MinimumHumidityThreshold { get; private set; }

    // Constructors
    public Thing(SerialNumber serialNumber, string model, EOperationMode operationMode, double maximumTemperatureThreshold, double minimumHumidityThreshold)
    {
        SerialNumber = serialNumber;
        Model = model;
        OperationMode = operationMode;

        if (maximumTemperatureThreshold is < -40.00 or > 85.00)
        {
            throw new ArgumentOutOfRangeException(nameof(maximumTemperatureThreshold), "Maximum Temperature Threshold must be between -40.00 and 85.00");
        }
        MaximumTemperatureThreshold = maximumTemperatureThreshold;

        if (minimumHumidityThreshold is < 0.00 or > 100.00)
        {
            throw new ArgumentOutOfRangeException(nameof(minimumHumidityThreshold), "Minimum Humidity Threshold must be between 0.00 and 100.00");
        }
        MinimumHumidityThreshold = minimumHumidityThreshold;
    }

    public Thing(CreateThingCommand command) : this(new SerialNumber(command.SerialNumber), command.Model, EOperationMode.ScheduleDriven, command.MaximumTemperatureThreshold, command.MinimumHumidityThreshold)
    {
    }
}