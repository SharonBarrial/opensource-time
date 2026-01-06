namespace si730ebu202317002.API.assessment.Interfaces.Rest.Resources;

public record CreateMentalStateExamResource(
    long PatientId,
    Guid ExaminerNationalProviderIdentifier,
    DateTime ExamDate,
    int OrientationScore,
    int RegistrationScore,
    int AttentionAndCalculationScore,
    int RecallScore,
    int LanguageScore
);  