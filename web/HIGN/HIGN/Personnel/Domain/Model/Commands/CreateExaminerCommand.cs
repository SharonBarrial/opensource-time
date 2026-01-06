namespace HIGN.Personnel.Domain.Model.Commands;

public record CreateExaminerCommand(string FirstName, string LastName, string NationalProviderIdentifier);