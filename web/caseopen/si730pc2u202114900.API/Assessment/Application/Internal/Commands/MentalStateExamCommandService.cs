using System.Runtime.InteropServices;
using si730pc2u202114900.API.Assessment.Domain.Models.Commands;
using si730pc2u202114900.API.Assessment.Domain.Models.Entities;
using si730pc2u202114900.API.Assessment.Domain.Repositories;
using si730pc2u202114900.API.Assessment.Domain.Services;
using si730pc2u202114900.API.Personnel.Domain.Services;
using si730pc2u202114900.API.Shared;
using si730pc2u202114900.API.Shared.Domain.Repositories;

namespace si730pc2u202114900.API.Assessment.Application.Internal.Commands;

/**
 * <summary>
 * This class is responsible for handling the CreateMentalStateExamCommand. It implements the IMentalStateExamCommandService interface.
 * It contains a constructor for initializing the service with necessary dependencies and a method for handling the command.
 * </summary>
 * <author>
 * Sharon Antuanet Ivet Barrial Marin
 * - Code Student: u202114900
 * </author>
 * <version>1.0.0</version>
 */
public class MentalStateExamCommandService :IMentalStateExamCommandService
{
    private readonly IMentalStateExamRepository _mentalStateExamRepository;
    private readonly IExaminerACLService _examinerACLService;
    private readonly IUnitOfWork _unitOfWork;
    
    /**
     * <summary>
     * Initializes a new instance of the MentalStateExamCommandService class with the provided dependencies.
     * </summary>
     * <param name="mentalStateExamRepository">The repository for MentalStateExam entities.</param>
     * <param name="examinerACLService">The service for examiner access control.</param>
     * <param name="unitOfWork">The unit of work for database transactions.</param>
     */

    public MentalStateExamCommandService(
        IMentalStateExamRepository mentalStateExamRepository,
        IExaminerACLService examinerACLService,
        IUnitOfWork unitOfWork)
    {
        _mentalStateExamRepository = mentalStateExamRepository;
        _examinerACLService = examinerACLService;
        _unitOfWork = unitOfWork;
    }
    
    /**
     * <summary>
     * Handles the CreateMentalStateExamCommand. It validates the command parameters, creates a new MentalStateExam entity,
     * adds it to the repository, and completes the unit of work.
     * </summary>
     * <param name="command">The command to create a new MentalStateExam.</param>
     * <returns>The created MentalStateExam entity.</returns>
     */
    
    public async Task<MentalStateExam?> Handle(CreateMentalStateExamCommand command)
    {
       
        if (string.IsNullOrEmpty(command.ExaminerNationalProviderIdentifier)) 
            throw new ArgumentException($"The examinerNationalProviderIdentifier provided for cannot be empty.");
        
        if (!Guid.TryParse(command.ExaminerNationalProviderIdentifier, out Guid nationalProviderIdentifier)) 
                 throw new ArgumentException("The value provided for examinerNationalProviderIdentifier must be a valid GUID version 4.");
        
        bool examinerExists = await _examinerACLService.ExistsExaminerAsync(command.ExaminerNationalProviderIdentifier);
        if (!examinerExists)
        {
            throw new ArgumentException($"Examiner with this {command.ExaminerNationalProviderIdentifier} examinerNationalProviderIdentifier provider does not exist");
        }

        if (command.ExamDate > DateTime.Now)
        {
            throw new InvalidOleVariantTypeException("Exam date cannot be in the future");
        } 
        if (command.OrientationScore < ScoreConstants.MinOrientationScore || command.OrientationScore > ScoreConstants.MaxOrientationScore)
        {
            throw new ArgumentException($"Orientation score must be between {ScoreConstants.MinOrientationScore} and {ScoreConstants.MaxOrientationScore}");
        }

        if (command.RegistrationScore < ScoreConstants.MinRegistrationScore || command.RegistrationScore > ScoreConstants.MaxRegistrationScore)
        {
            throw new ArgumentException($"Registration score must be between {ScoreConstants.MinRegistrationScore} and {ScoreConstants.MaxRegistrationScore}");
        }

        if (command.AttentionAndCalculationScore < ScoreConstants.MinAttentionAndCalculationScore || command.AttentionAndCalculationScore > ScoreConstants.MaxAttentionAndCalculationScore)
        {
            throw new ArgumentException($"Attention and calculation score must be between {ScoreConstants.MinAttentionAndCalculationScore} and {ScoreConstants.MaxAttentionAndCalculationScore}");
        }

        if (command.RecallScore < ScoreConstants.MinRecallScore || command.RecallScore > ScoreConstants.MaxRecallScore)
        {
            throw new ArgumentException($"Recall score must be between {ScoreConstants.MinRecallScore} and {ScoreConstants.MaxRecallScore}");
        }

        if (command.LanguageScore < ScoreConstants.MinLanguageScore || command.LanguageScore > ScoreConstants.MaxLanguageScore)
        {
            throw new ArgumentException($"Language score must be between {ScoreConstants.MinLanguageScore} and {ScoreConstants.MaxLanguageScore}");
        }
        var exam = new MentalStateExam(command);
        await _mentalStateExamRepository.AddAsync(exam);
        await _unitOfWork.CompleteAsync();
        return exam;
    }
    
}