using HIGN.Assessment.Domain.Model.Aggregates;
using HIGN.Assessment.Interfaces.REST.Resources;

namespace HIGN.Assessment.Interfaces.REST.Transform;

public class MentalStateExamResourceFromEntityAssembler
{
    public static MentalStateExamResource ToResourceFromEntity(MentalStateExam mentalStateExam)
    {
        return new MentalStateExamResource(mentalStateExam.Id, mentalStateExam.PatientId,
            mentalStateExam.NationalProvideIdentifier,
            mentalStateExam.ExamDate, mentalStateExam.OrientationScore, mentalStateExam.RegistrationScore,
            mentalStateExam.AttentionAndCalculationScore, mentalStateExam.RecallScore,
            mentalStateExam.LanguageScore, mentalStateExam.ExaminerId);
    }
}