using si730ebu202317002.API.personnel.Domain.Model.Commands;

namespace si730ebu202317002.API.personnel.Domain.Model.Aggregates;

public partial class Examiner
{
    public long Id { get; }
    public string firstName { get; set; }
    public string lastName { get; set; }
    public Guid nationalProviderIdentifier { get; set; }
    
    public Examiner() {}
    
public Examiner(CreateExaminerCommand command)
    {
        firstName = command.FirstName;
        lastName = command.LastName;
        nationalProviderIdentifier = command.NationalProviderIdentifier;
    }
    
}