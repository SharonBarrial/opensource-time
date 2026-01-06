using si730pc2u202114900.API.Inventory.Domain.Models.Commands;
using si730pc2u202114900.API.Inventory.Domain.Models.Entities;

namespace si730pc2u202114900.API.Inventory.Domain.Services;

/**
 * <summary>
 * Represents the service interface for handling the CreateThingCommand. This interface defines a method for handling the command.
 * </summary>
 * <author>
 * Sharon Antuanet Ivet Barrial Marin
 * - Code Student: u202114900
 * </author>
 * <version>1.0.0</version>
 */
public interface IThingCommandService
{
    /**
     * <summary>
     * Handles the CreateThingCommand. It validates the command parameters, creates a new Thing entity,
     * and returns the created entity.
     * </summary>
     * <param name="command">The command to create a new Thing.</param>
     * <returns>A task that represents the asynchronous operation. The task result contains the created Thing entity.</returns>
     */
    Task<Thing?> Handle(CreateThingCommand command);
}