using BasePlatform.API.Urgency.Domain.Models.Commands;

namespace BasePlatform.API.Urgency.Domain;

public interface IGuardianCommandService
{
    Task<int> handle (CreatedGuardianCommand command);
}