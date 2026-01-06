using BasePlatform.API.Shared.Domain.Repositories;
using BasePlatform.API.Urgency.Domain.Models.Entities;

namespace BasePlatform.API.Urgency.Domain.Repositories;

public interface IGuardianRepository : IBaseRepository<Guardian>
{
    Task<List<Guardian>> GetGuardiansByUsername(string username);
}