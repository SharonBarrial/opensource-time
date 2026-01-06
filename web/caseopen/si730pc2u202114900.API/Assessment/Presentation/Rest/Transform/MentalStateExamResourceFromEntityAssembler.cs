using si730pc2u202114900.API.Assessment.Domain.Models.Entities;
using si730pc2u202114900.API.Assessment.Presentation.Rest.Resource;

namespace si730pc2u202114900.API.Assessment.Presentation.Rest.Transform;

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