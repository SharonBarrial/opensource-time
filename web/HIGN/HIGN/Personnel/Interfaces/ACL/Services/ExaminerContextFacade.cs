
using HIGN.Personnel.Domain.Services;

namespace HIGN.Personnel.Interfaces.ACL.Services;

/**
 * ExaminerContextFacade
 * <summary>
 *       This class is a facade for the Examiner context. It is used to create an Examiner.
 * </summary>
 */
public class ExaminerContextFacade(IExaminerQueryService examinerQueryService) : IExaminerContextFacade
{

  public async Task<long> FetchExaminerIdAsync(long id)
  {
      var examiner = await examinerQueryService.GetExaminerByIdAsync(id);
      return examiner?.Id ?? 0L;
  }
}