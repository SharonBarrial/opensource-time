namespace HIGN.Personnel.Interfaces.ACL;

public interface IExaminerContextFacade
{
   Task<long> FetchExaminerIdAsync(long id);
}