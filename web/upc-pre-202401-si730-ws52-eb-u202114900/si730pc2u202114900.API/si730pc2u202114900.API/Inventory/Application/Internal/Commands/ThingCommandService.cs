using si730pc2u202114900.API.Inventory.Domain.Models.Commands;
using si730pc2u202114900.API.Inventory.Domain.Models.Entities;
using si730pc2u202114900.API.Inventory.Domain.Repositories;
using si730pc2u202114900.API.Inventory.Domain.Services;
using si730pc2u202114900.API.Shared;
using si730pc2u202114900.API.Shared.Domain.Repositories;

namespace si730pc2u202114900.API.Inventory.Application.Internal.Commands;

/**
 * <summary>
 * This class is responsible for handling the CreateThingCommand. It implements the IThingCommandService interface.
 * It contains a constructor for initializing the service with necessary dependencies and a method for handling the command.
 * </summary>
 * <author>
 * Sharon Antuanet Ivet Barrial Marin
 * - Code Student: u202114900
 * </author>
 * <version>1.0.0</version>
 */
public class ThingCommandService :IThingCommandService
{
    private readonly IThingRepository _thingRepository;
    private readonly IUnitOfWork _unitOfWork;
    
    /**
     * <summary>
     * Initializes a new instance of the ThingStateCommandService class with the provided dependencies.
     * </summary>
     * <param name="thingRepository">The repository for Thing entities.</param>
     * <param name="unitOfWork">The unit of work for database transactions.</param>
     */

    public ThingCommandService(
        IThingRepository thingRepository,
        IUnitOfWork unitOfWork)
    {
        _thingRepository = thingRepository;
        _unitOfWork = unitOfWork;
    }
    
    /**
     * <summary>
     * Handles the CreateThingCommand. It validates the command parameters, creates a new Thing entity,
     * adds it to the repository, and completes the unit of work.
     * </summary>
     * <param name="command">The command to create a new Thing.</param>
     * <returns>The created Thing entity.</returns>
     */
    
    public async Task<Thing?> Handle(CreateThingCommand command)
    {
        
        bool thingExists =
            await _thingRepository.ExistsThingWithSerialNumberAsync(command.SerialNumber);
        if (thingExists)
        {
            throw new InvalidOperationException(
                "Thing with the serial number provided already exists");
        }
        if (command.MaximumTemperatureThreshold < ScoreConstants.MinMaximumTemperatureThreshold || command.MaximumTemperatureThreshold > ScoreConstants.MaxMaximumTemperatureThreshold)
        {
            throw new ArgumentException("Maximum Temperature Threshold must be a decimal between -40.00 and 85.00");
        }
        
        if (command.MinimumHumidityThreshold < ScoreConstants.MinMinimumHumidityThreshold || command.MinimumHumidityThreshold > ScoreConstants.MaxMinimumHumidityThreshold)
        {
            throw new ArgumentException("Minimum Humidity Threshold must be a decimal between 0.00 and 100.00");
        }


        var thing = new Thing(command);
        await _thingRepository.AddAsync(thing);
        await _unitOfWork.CompleteAsync();
        return thing;
    }
    
}