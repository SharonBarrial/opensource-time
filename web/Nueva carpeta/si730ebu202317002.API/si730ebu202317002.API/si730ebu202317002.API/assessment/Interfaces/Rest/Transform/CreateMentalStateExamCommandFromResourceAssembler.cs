using si730ebu202317002.API.assessment.Domain.Model.Commands;
using si730ebu202317002.API.assessment.Interfaces.Rest.Resources;

namespace si730ebu202317002.API.assessment.Interfaces.Rest.Transform;

public static class CreateMentalStateExamCommandFromResourceAssembler
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