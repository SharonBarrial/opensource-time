namespace HIGN.Assessment.Interfaces.REST.Resources;

public record CreateMentalStateExamResource(long PatientId, string NationalProvideIdentifier, DateTime ExamDate, int OrientationScore, int RegistrationScore, int AttentionAndCalculationScore, int RecallScore, int LanguageScore, long ExaminerId);