namespace si730ebu202317002.API.assessment.Domain.Model.Commands;

public record CreateMentalStateExamCommand(
    long PatientId,
    Guid ExaminerNationalProviderIdentifier,
    DateTime ExamDate,
    int OrientationScore,
    int RegistrationScore,
    int AttentionAndCalculationScore,
    int RecallScore,
    int LanguageScore
);