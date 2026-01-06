using Microsoft.EntityFrameworkCore.Storage.ValueConversion;

namespace si730ebu20221c936.Shared.Domain.Model.ValueObjects;

public record SerialNumber(Guid Value)
{
    public SerialNumber(): this(Guid.NewGuid()){}
}

public class SerialNumberConverter() : ValueConverter<SerialNumber, Guid>(serialNumber => serialNumber.Value,
    guid => new SerialNumber(guid));