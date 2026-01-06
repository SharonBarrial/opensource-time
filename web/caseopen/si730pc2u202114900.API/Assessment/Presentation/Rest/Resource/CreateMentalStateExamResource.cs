namespace si730pc2u202114900.API.Assessment.Presentation.Rest.Resource;

public record CreateMentalStateExamResource(
    long PatientId,
    string ExaminerNationalProviderIdentifier,
    DateTime ExamDate,
    int OrientationScore,
    int RegistrationScore,
    int AttentionAndCalculationScore,
    int RecallScore,
    int LanguageScore
    );