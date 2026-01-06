namespace si730ebu202317002.API.personnel.Interfaces.Rest.Resources;

public record ExaminerResource(
    long Id,
    string FirstName,
    string LastName,
    Guid NationalProviderIdentifier
);