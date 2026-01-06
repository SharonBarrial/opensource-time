using System.ComponentModel.DataAnnotations;
using si730ebu202317002.API.assessment.Domain.Model.Commands;

namespace si730ebu202317002.API.assessment.Domain.Model.Aggregates;

public partial class  MentalStateExam
{
    public long Id { get; set; }
    public long PatientId { get; set; }
    public Guid ExaminerNationalProviderIdentifier { get; set; }
    public DateTime ExamDate { get; set; } 
    
    [Range(0, 10)]
    public int OrientationScore { get; private set; }

    
    [Range(0, 3)]
    public int RegistrationScore { get; private set; }

    
    public int AttentionAndCalculationScore { get; private set; }

    [Range(0, 3)]
    public int RecallScore { get; private set; }

    [Range(0, 9)]
    public int LanguageScore { get; private set; }
    
    
    private MentalStateExam() { }

    public MentalStateExam(CreateMentalStateExamCommand command)
    {
        PatientId = command.PatientId;
        ExaminerNationalProviderIdentifier = command.ExaminerNationalProviderIdentifier;
        ExamDate = command.ExamDate;
        OrientationScore = command.OrientationScore;
        RegistrationScore = command.RegistrationScore;
        AttentionAndCalculationScore = command.AttentionAndCalculationScore;
        RecallScore = command.RecallScore;
        LanguageScore = command.LanguageScore;
    }
    //public string FormattedExamDate => ExamDate.ToString("yyyy-MM-dd");

}