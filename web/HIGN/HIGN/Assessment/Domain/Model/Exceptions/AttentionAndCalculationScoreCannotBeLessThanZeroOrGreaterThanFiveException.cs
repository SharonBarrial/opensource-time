namespace HIGN.Assessment.Domain.Model.Exceptions;

public class AttentionAndCalculationScoreCannotBeLessThanZeroOrGreaterThanFiveException : Exception
{
    public AttentionAndCalculationScoreCannotBeLessThanZeroOrGreaterThanFiveException() : base("Attention and calculation score cannot be less than zero or greater than five.")
    {
    }
}