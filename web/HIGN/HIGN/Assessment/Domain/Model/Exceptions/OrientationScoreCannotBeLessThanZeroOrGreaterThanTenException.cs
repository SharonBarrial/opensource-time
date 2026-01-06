namespace HIGN.Assessment.Domain.Model.Exceptions;

public class OrientationScoreCannotBeLessThanZeroOrGreaterThanTenException : Exception
{
    public OrientationScoreCannotBeLessThanZeroOrGreaterThanTenException() : base("Orientation score cannot be less than 0 or greater than 10")
    {
    }
}