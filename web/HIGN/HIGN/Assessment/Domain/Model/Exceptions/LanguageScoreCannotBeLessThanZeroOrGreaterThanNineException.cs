namespace HIGN.Assessment.Domain.Model.Exceptions;

public class LanguageScoreCannotBeLessThanZeroOrGreaterThanNineException : Exception
{
    public LanguageScoreCannotBeLessThanZeroOrGreaterThanNineException() : base("Language score cannot be less than 0 or greater than 9")
    {
    }
}