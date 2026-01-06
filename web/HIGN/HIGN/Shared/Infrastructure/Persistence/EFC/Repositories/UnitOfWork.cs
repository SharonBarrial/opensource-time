using HIGN.Shared.Domain.Repositories;
using HIGN.Shared.Infrastructure.Persistence.EFC.Configuration;

namespace HIGN.Shared.Infrastructure.Persistence.EFC.Repositories;

public class UnitOfWork(AppDbContext context) : IUnitOfWork
{

    public async Task CompleteAsync() => await context.SaveChangesAsync();
    
}