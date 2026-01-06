using HIGN.Assessment.Domain.Model.Commands;
using HIGN.Personnel.Domain.Model.Aggregates;
using HIGN.Personnel.Domain.Model.ValueObjects;

namespace HIGN.Assessment.Domain.Model.Aggregates;

public partial class MentalStateExam
{
    public long Id { get; }
    public long ExaminerId { get; set; }
    public long PatientId { get; set; }
    public NationalProvideIdentifier NationalProvideIdentifierValueObject { get; set; }
    public DateTime ExamDate { get; set; }
    public int OrientationScore { get; set; }
    public int RegistrationScore { get; set; }
    public int AttentionAndCalculationScore { get; set; }
    public int RecallScore { get; set; }
    public int LanguageScore { get; set; }
    
    public Examiner Examiner { get; set; }
}

public partial class MentalStateExam
{
    public string NationalProvideIdentifier => NationalProvideIdentifierValueObject.Value.ToString();
}

public partial class MentalStateExam
{
    public MentalStateExam()
    {
        ExaminerId = 0;
        PatientId = 0;
        NationalProvideIdentifierValueObject = new NationalProvideIdentifier(string.Empty);
        ExamDate = DateTime.MinValue;
        OrientationScore = 0;
        RegistrationScore = 0;
        AttentionAndCalculationScore = 0;
        RecallScore = 0;
        LanguageScore = 0;
    }

    public MentalStateExam(CreateMentalStateExamCommand command)
    {
        ExaminerId = command.ExaminerId;
        PatientId = command.PatientId;
        NationalProvideIdentifierValueObject = new NationalProvideIdentifier(command.NationalProvideIdentifier);
        ExamDate = command.ExamDate;
        OrientationScore = command.OrientationScore;
        RegistrationScore = command.RegistrationScore;
        AttentionAndCalculationScore = command.AttentionAndCalculationScore;
        RecallScore = command.RecallScore;
        LanguageScore = command.LanguageScore;
        CreatedDate = DateTime.UtcNow;
        UpdatedDate = null;

    }
}