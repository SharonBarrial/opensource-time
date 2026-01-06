using si730pc2u202114900.API.Inventory.Domain.Services;
using si730pc2u202114900.API.Observability.Domain.Models.Commands;
using si730pc2u202114900.API.Observability.Domain.Models.Entities;
using si730pc2u202114900.API.Observability.Domain.Repositories;
using si730pc2u202114900.API.Observability.Domain.Services;
using si730pc2u202114900.API.Shared.Domain.Repositories;

namespace si730pc2u202114900.API.Observability.Application.Internal.CommandServices;

public class ThingStateCommandService :IThingStateCommandService
{
    private readonly IThingStateRepository _thingStateRepository;
    private readonly IThingACLService _thingAclService;
    private readonly IUnitOfWork _unitOfWork;
    
    /**
     * <summary>
     * Initializes a new instance of the MentalStateExamCommandService class with the provided dependencies.
     * </summary>
     * <param name="mentalStateExamRepository">The repository for MentalStateExam entities.</param>
     * <param name="examinerACLService">The service for examiner access control.</param>
     * <param name="unitOfWork">The unit of work for database transactions.</param>
     */

    public ThingStateCommandService(
        IThingStateRepository thingStateRepository,
        IThingACLService thingAclService,
        IUnitOfWork unitOfWork)
    {
        _thingStateRepository = thingStateRepository;
        _thingAclService = _thingAclService;
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
    
    public async Task<ThingState?> Handle(CreateThingStateCommand command)
    {
       
       bool thingExists = await _thingAclService.ExistsSerialNumberAsync(command.ThingSerialNumber);
        if (!thingExists)
        {
            throw new ArgumentException($"Examiner with this {command.ThingSerialNumber} Thing Serial number provider does not exist");
        }
        
        var thingState = new ThingState(command);
        await _thingStateRepository.AddAsync(thingState);
        await _unitOfWork.CompleteAsync();
        return thingState;
    }
    
}