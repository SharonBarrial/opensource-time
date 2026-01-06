using si730pc2u202114900.API.Observability.Domain.Models.Entities;
using si730pc2u202114900.API.Observability.Presentation.Rest.Resources;

namespace si730pc2u202114900.API.Observability.Presentation.Rest.Transform;

public class ThingStateResourceFromEntityAssembler
{
    public static ThingStateResource ToResourceFromEntity(ThingState entity)
    {
        return new ThingStateResource(
            entity.Id,
            entity.ThingSerialNumber,
            entity.CurrentOperationMode,
            entity.CurrentTemperature,
            entity.CurrentHumidity,
            entity.CollectedAt
        );
    }
}