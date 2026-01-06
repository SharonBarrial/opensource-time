using si730pc2u202114900.API.Observability.Domain.Models.Commands;
using si730pc2u202114900.API.Observability.Presentation.Rest.Resources;

namespace si730pc2u202114900.API.Observability.Presentation.Rest.Transform;

public class CreateThingStateCommandFromResourceAssembler
{
    public static CreateThingStateCommand ToCommandFromResource(CreateThingStateResource resource)
    {
        return new CreateThingStateCommand(
            resource.ThingSerialNumber,
            resource.CurrentOperationMode,
            resource.CurrentTemperature,
            resource.CurrentHumidity,
            resource.CollectedAt
        );
    }
}