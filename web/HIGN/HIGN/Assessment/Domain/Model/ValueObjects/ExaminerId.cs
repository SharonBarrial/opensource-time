namespace HIGN.Assessment.Domain.Model.ValueObjects;

public record ExaminerId(long Id){
    public ExaminerId() : this(0L)
    {

    }
}