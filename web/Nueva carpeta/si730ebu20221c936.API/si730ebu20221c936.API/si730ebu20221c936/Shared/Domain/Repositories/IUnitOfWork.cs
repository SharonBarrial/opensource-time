namespace si730ebu20221c936.Shared.Domain.Repositories;


public interface IUnitOfWork
{
    Task CompleteAsync();
}