using si730pc2u202114900.API.Observability.Domain.Models.Commands;
using si730pc2u202114900.API.Observability.Domain.Models.Entities;

namespace si730pc2u202114900.API.Observability.Domain.Services;

public interface IThingStateCommandService
{
    Task<ThingState?> Handle(CreateThingStateCommand command);
}