using HIGN.Assessment.Domain.Model.Aggregates;
using HIGN.Personnel.Domain.Model.Commands;
using HIGN.Personnel.Domain.Model.ValueObjects;

namespace HIGN.Personnel.Domain.Model.Aggregates;

public partial class Examiner
{
    public long Id { get; }
    public string FirstName { get; set; }
    public string LastName { get; set; }
    
    public NationalProvideIdentifier NationalProvideIdentifierValueObj { get; set; }
    
    public ICollection<MentalStateExam> MentalStateExams { get; set; }
}

public partial class Examiner
{
    public string NationalProviderIdentifier => NationalProvideIdentifierValueObj.Value.ToString();
}

public partial class Examiner
{
    public Examiner()
    {
        FirstName = string.Empty;
        LastName = string.Empty;
        NationalProvideIdentifierValueObj = new NationalProvideIdentifier(Guid.Empty);
    }

    public Examiner(CreateExaminerCommand command)
    {
        FirstName = command.FirstName;
        LastName = command.LastName;
        NationalProvideIdentifierValueObj = new NationalProvideIdentifier(command.NationalProviderIdentifier);
        CreatedDate = DateTime.UtcNow;
        UpdatedDate = null;
    }
    
}