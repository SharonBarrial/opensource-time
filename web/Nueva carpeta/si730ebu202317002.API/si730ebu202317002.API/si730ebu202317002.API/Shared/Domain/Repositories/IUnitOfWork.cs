namespace si730ebu202317002.API.Shared.Domain.Repositories;

public interface IUnitOfWork
{
    Task CompleteAsync();
}