using si730pc2u202114900.API.Assessment.Domain.Models.Commands;
using si730pc2u202114900.API.Assessment.Domain.Models.Entities;

namespace si730pc2u202114900.API.Assessment.Domain.Services;

/**
 * <summary>
 * Represents the service interface for handling the CreateMentalStateExamCommand. This interface defines a method for handling the command.
 * </summary>
 * <author>
 * Sharon Antuanet Ivet Barrial Marin
 * - Code Student: u202114900
 * </author>
 * <version>1.0.0</version>
 */
public interface IMentalStateExamCommandService
{
    /**
     * <summary>
     * Handles the CreateMentalStateExamCommand. It validates the command parameters, creates a new MentalStateExam entity,
     * and returns the created entity.
     * </summary>
     * <param name="command">The command to create a new MentalStateExam.</param>
     * <returns>A task that represents the asynchronous operation. The task result contains the created MentalStateExam entity.</returns>
     */
    Task<MentalStateExam?> Handle(CreateMentalStateExamCommand command);
}