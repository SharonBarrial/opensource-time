using si730ebu202317002.API.assessment.Domain.Model.Aggregates;
using si730ebu202317002.API.assessment.Domain.Model.Commands;

namespace si730ebu202317002.API.assessment.Domain.Services;

public interface IMentalStateExamCommandService
{
    Task<MentalStateExam?> Handle(CreateMentalStateExamCommand command);
}