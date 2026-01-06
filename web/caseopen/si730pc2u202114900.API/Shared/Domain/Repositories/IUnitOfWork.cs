namespace si730pc2u202114900.API.Shared.Domain.Repositories;

public interface IUnitOfWork
{
    Task CompleteAsync();
}