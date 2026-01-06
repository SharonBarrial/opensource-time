namespace HIGN.Assessment.Domain.Model.Exceptions;

public class ExaminerIdNotFoundException : Exception
{
    public ExaminerIdNotFoundException() : base("Examiner ID not found.")
    {
    }
}