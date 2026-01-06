namespace si730pc2u202114900.API.Personnel.Domain.Services;

public interface IExaminerACLService
{
    Task<bool> ExistsExaminerAsync(string examinerNationalProviderIdentifier);
}
