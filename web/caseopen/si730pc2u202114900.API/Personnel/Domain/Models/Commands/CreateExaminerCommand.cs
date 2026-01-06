namespace si730pc2u202114900.API.Personnel.Domain.Models.Commands;

public record CreateExaminerCommand(string FirstName, string LastName, string NationalProviderIdentifier);