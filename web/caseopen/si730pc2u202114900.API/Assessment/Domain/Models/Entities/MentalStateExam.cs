using System.ComponentModel.DataAnnotations;
using Microsoft.EntityFrameworkCore;
using si730pc2u202114900.API.Assessment.Domain.Models.Commands;
using si730pc2u202114900.API.Personnel.Domain.Models.Entities;

namespace si730pc2u202114900.API.Assessment.Domain.Models.Entities;

/**
 * <summary>
 * Represents a mental state exam. This class is a child of the MentalStateExamAudit class.
 * It contains properties for the exam's ID, patient ID, examiner's national provider identifier, exam date, and scores for various mental state aspects.
 * It also includes a constructor for creating a new mental state exam from a CreateMentalStateExamCommand.
 * </summary>
 * <author>
 * Sharon Antuanet Ivet Barrial Marin
 * - Code Student: u202114900
 * </author>
 * <version>1.0.0</version>
 */
public class MentalStateExam: MentalStateExamAudit
{
    public long Id { get; set; }
    public long PatientId { get; set; }
    public string ExaminerNationalProviderIdentifier { get; set; }
    public DateTime ExamDate { get; set; }
    
    [Range(0,10)]
    public int OrientationScore { get; private set; }
    [Range(0, 3)]
    public int RegistrationScore { get; private set; }
    [Range(0, 5)]
    public int AttentionAndCalculationScore { get; private set; }
    [Range(0, 3)]
    public int RecallScore { get; private set; }
    [Range(0, 9)]
    public int LanguageScore { get; private set; }
    
    private MentalStateExam() { }
    
    /**
     * <summary>
     * Constructs a new MentalStateExam from a CreateMentalStateExamCommand.
     * </summary>
     * <param name="command">The command containing the data for the new mental state exam.</param>
     */
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
}