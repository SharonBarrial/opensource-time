using si730pc2u202114900.API.Assessment.Domain.Models.Commands;
using si730pc2u202114900.API.Assessment.Presentation.Rest.Resource;

namespace si730pc2u202114900.API.Assessment.Presentation.Rest.Transform;

public class CreateMentalStateExamCommandFromResourceAssembler
{
    public static CreateMentalStateExamCommand ToCommandFromResource(CreateMentalStateExamResource resource)
    {
        return new CreateMentalStateExamCommand(
            resource.PatientId,
            resource.ExaminerNationalProviderIdentifier,
            resource.ExamDate,
            resource.OrientationScore,
            resource.RegistrationScore,
            resource.AttentionAndCalculationScore,
            resource.RecallScore,
            resource.LanguageScore
        );
    }
}