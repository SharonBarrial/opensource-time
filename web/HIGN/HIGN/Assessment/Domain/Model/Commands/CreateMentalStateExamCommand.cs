namespace HIGN.Assessment.Domain.Model.Commands;

public record CreateMentalStateExamCommand(long PatientId, string NationalProvideIdentifier, DateTime ExamDate, int OrientationScore, int RegistrationScore, int AttentionAndCalculationScore, int RecallScore, int LanguageScore, long ExaminerId);