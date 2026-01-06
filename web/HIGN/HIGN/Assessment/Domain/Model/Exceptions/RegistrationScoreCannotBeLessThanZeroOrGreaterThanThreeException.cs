namespace HIGN.Assessment.Domain.Model.Exceptions;

public class RegistrationScoreCannotBeLessThanZeroOrGreaterThanThreeException : Exception
{
    public RegistrationScoreCannotBeLessThanZeroOrGreaterThanThreeException() : base("Registration score cannot be less than 0 or greater than 3")
    {
    }
}