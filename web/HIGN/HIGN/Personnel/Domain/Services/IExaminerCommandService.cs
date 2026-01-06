using HIGN.Personnel.Domain.Model.Aggregates;
using HIGN.Personnel.Domain.Model.Commands;

namespace HIGN.Personnel.Domain.Services;

public interface IExaminerCommandService
{
    Task<Examiner?> Handle(CreateExaminerCommand command);
}