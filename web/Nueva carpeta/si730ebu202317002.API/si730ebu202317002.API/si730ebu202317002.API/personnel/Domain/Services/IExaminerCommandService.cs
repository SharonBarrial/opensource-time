using si730ebu202317002.API.personnel.Domain.Model.Aggregates;
using si730ebu202317002.API.personnel.Domain.Model.Commands;

namespace si730ebu202317002.API.personnel.Domain.Services;

public interface IExaminerCommandService
{
    Task<Examiner?> Handle(CreateExaminerCommand command);
}