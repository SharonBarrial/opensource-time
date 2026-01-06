using HIGN.Assessment.Domain.Model.Commands;
using HIGN.Assessment.Interfaces.REST.Resources;
namespace HIGN.Assessment.Interfaces.REST.Transform;

public class CreateMentalStateExamCommandFromResourceAssembler
{
    public static CreateMentalStateExamCommand ToCommandFromResource(CreateMentalStateExamResource resource)
    {
        return new CreateMentalStateExamCommand(resource.PatientId, resource.NationalProvideIdentifier,
            resource.ExamDate, resource.OrientationScore, resource.RegistrationScore,
            resource.AttentionAndCalculationScore, resource.RecallScore, resource.LanguageScore, resource.ExaminerId);
    }
}