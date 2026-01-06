using si730ebu202317002.API.assessment.Domain.Model.Aggregates;
using si730ebu202317002.API.assessment.Interfaces.Rest.Resources;

namespace si730ebu202317002.API.assessment.Interfaces.Rest.Transform;

public static class MentalStateExamResourceFromEntityAssembler
{
    public static MentalStateExamResource ToResourceFromEntity(MentalStateExam entity)
    {
        return new MentalStateExamResource(
            entity.Id,
            entity.PatientId,
            entity.ExaminerNationalProviderIdentifier,
            entity.ExamDate,
            entity.OrientationScore,
            entity.RegistrationScore,
            entity.AttentionAndCalculationScore,
            entity.RecallScore,
            entity.LanguageScore
        );
    }
}
