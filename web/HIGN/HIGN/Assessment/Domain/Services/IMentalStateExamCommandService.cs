using HIGN.Assessment.Domain.Model.Aggregates;
using HIGN.Assessment.Domain.Model.Commands;

namespace HIGN.Assessment.Domain.Services;

public interface IMentalStateExamCommandService
{
    Task<MentalStateExam?> Handle(CreateMentalStateExamCommand command);
}