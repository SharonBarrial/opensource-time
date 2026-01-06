using si730pc2u202114900.API.Personnel.Domain.Models.Commands;
using si730pc2u202114900.API.Personnel.Domain.Models.Entities;

namespace si730pc2u202114900.API.Personnel.Domain.Services;

public interface IExaminerCommandService
{
    Task<Examiner?> Handle(CreateExaminerCommand command);
}