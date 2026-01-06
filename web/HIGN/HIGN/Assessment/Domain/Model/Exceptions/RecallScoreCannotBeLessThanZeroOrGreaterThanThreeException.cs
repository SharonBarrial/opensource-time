namespace HIGN.Assessment.Domain.Model.Exceptions;

public class RecallScoreCannotBeLessThanZeroOrGreaterThanThreeException : Exception
{
    public RecallScoreCannotBeLessThanZeroOrGreaterThanThreeException() : base("Recall score cannot be less than zero or greater than three.")
    {
    }
}