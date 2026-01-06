namespace si730ebu202317002.API.personnel.Domain.Services;

public interface IExaminerACLService
{
    Task<bool> ExistsExaminerAsync(Guid examinerNationalProviderIdentifier);
}