namespace si730ebu202317002.API.personnel.Domain.Model.Commands;

public record CreateExaminerCommand( string FirstName, string LastName, Guid NationalProviderIdentifier);