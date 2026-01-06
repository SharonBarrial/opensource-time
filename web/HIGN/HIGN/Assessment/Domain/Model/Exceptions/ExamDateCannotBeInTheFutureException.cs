namespace HIGN.Assessment.Domain.Model.Exceptions;

public class ExamDateCannotBeInTheFutureException : Exception
{
    public ExamDateCannotBeInTheFutureException() : base("Exam date cannot be in the future")
    {
    }
}