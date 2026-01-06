namespace HIGN.Personnel.Domain.Model.Exceptions;

public class ExaminerWithThisNationalProviderIdentifierAlreadyExistsException : Exception
{
    public ExaminerWithThisNationalProviderIdentifierAlreadyExistsException() : base("Examiner with this National Provider Identifier already exists.")
    {
        
    }
}