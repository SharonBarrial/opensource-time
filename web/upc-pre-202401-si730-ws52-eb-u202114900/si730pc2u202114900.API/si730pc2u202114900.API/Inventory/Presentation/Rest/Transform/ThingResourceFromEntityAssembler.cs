using si730pc2u202114900.API.Inventory.Domain.Models.Entities;
using si730pc2u202114900.API.Inventory.Presentation.Rest.Resource;

namespace si730pc2u202114900.API.Inventory.Presentation.Rest.Transform;

/// <summary>
/// Assembler class to transform Thing entities into ThingStateResource objects.
/// </summary>
public static class ThingResourceFromEntityAssembler
{
    /// <summary>
    /// Transforms a Thing entity into a ThingStateResource object.
    /// </summary>
    /// <param name="entity">The Thing entity to transform.</param>
    /// <returns>A ThingStateResource object.</returns>
    public static ThingResource ToResourceFromEntity(Thing entity)
    {
        return new ThingResource(
            entity.Id,
            entity.SerialNumber,
            entity.Model,
            entity.OperationMode,
            entity.MaximumTemperatureThreshold,
            entity.MinimumHumidityThreshold
        );
    }
}