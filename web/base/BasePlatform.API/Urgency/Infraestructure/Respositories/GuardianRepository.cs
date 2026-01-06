using BasePlatform.API.Shared.Infrastructure.Persistence.EFC.Configuration;
using BasePlatform.API.Shared.Infrastructure.Persistence.EFC.Repositories;
using BasePlatform.API.Urgency.Domain.Models.Entities;
using BasePlatform.API.Urgency.Domain.Repositories;
using Microsoft.EntityFrameworkCore;

namespace BasePlatform.API.Urgency.Infraestructure.Respositories;

public class GuardianRepository : BaseRepository<Guardian>,IGuardianRepository
{
    public GuardianRepository(AppDbContext context) : base(context)
    {
    }

    public async Task<List<Guardian>> GetGuardiansByUsername(string username)
    {
        //Context.Guardians.Where(g => g.Username == username).ToList();
        var result = await Context.Set<Guardian>().Where(g => g.Username == username).ToListAsync();
        return result;
    }
}