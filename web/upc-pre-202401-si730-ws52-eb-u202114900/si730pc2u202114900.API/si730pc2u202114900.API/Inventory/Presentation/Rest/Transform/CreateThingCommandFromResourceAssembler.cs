using si730pc2u202114900.API.Inventory.Domain.Models.Commands;
using si730pc2u202114900.API.Inventory.Presentation.Rest.Resource;

namespace si730pc2u202114900.API.Inventory.Presentation.Rest.Transform
{
    /// <summary>
    /// Assembler class to transform CreateThingStateResource objects into CreateThingCommand objects.
    /// </summary>
    public class CreateThingCommandFromResourceAssembler
    {
        /// <summary>
        /// Transforms a CreateThingStateResource object into a CreateThingCommand object.
        /// </summary>
        /// <param name="resource">The CreateThingStateResource object to transform.</param>
        /// <returns>A CreateThingCommand object.</returns>
        public static CreateThingCommand ToCommandFromResource(CreateThingResource resource)
        {
            return new CreateThingCommand(
                resource.SerialNumber,
                resource.Model,
                resource.OperationMode,
                resource.MaximumTemperatureThreshold,
                resource.MinimumHumidityThreshold
            );
        }
    }
}