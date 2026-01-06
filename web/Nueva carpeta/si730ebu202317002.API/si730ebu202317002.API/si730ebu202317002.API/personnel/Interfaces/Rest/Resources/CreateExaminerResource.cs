namespace si730ebu202317002.API.personnel.Interfaces.Rest.Resources;

public record CreateExaminerResource(
    string FirstName,
    string LastName,
    Guid NationalProviderIdentifier
);