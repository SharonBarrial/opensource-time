using si730pc2u202114900.API.Assessment.Domain.Models.Entities;
using si730pc2u202114900.API.Personnel.Domain.Models.Commands;

namespace si730pc2u202114900.API.Personnel.Domain.Models.Entities;

public class Examiner : ExaminerAudit
{
    public int Id { get; set; }
    public string FirstName { get; set; }
    public string LastName { get; set; }
    public string NationalProviderIdentifier { get; set; }
    
    
    public Examiner() {}
    
    public Examiner(CreateExaminerCommand command)
    {
        FirstName = command.FirstName;
        LastName = command.LastName;
        NationalProviderIdentifier = command.NationalProviderIdentifier;
    }
}