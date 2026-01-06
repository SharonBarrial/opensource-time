using si730ebu20221c936.Shared.Domain.Repositories;
using si730ebu20221c936.Shared.Infrastructure.Persistence.EFC.Configuration;

namespace si730ebu20221c936.Shared.Infrastructure.Persistence.EFC.Repositories;

public class UnitOfWork(AppDbContext context) : IUnitOfWork
{
    public async Task CompleteAsync() => await context.SaveChangesAsync();
}