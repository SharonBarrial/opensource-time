namespace HIGN.Personnel.Domain.Model.ValueObjects;

public record NationalProvideIdentifier(Guid Value)
{
    public NationalProvideIdentifier(string value) : this(Guid.Parse(value))
    {
    }
}
