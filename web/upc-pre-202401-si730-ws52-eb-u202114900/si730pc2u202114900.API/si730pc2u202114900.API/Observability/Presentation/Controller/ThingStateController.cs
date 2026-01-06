using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using si730pc2u202114900.API.Observability.Domain.Repositories;
using si730pc2u202114900.API.Observability.Domain.Services;
using si730pc2u202114900.API.Observability.Presentation.Rest.Resources;
using si730pc2u202114900.API.Observability.Presentation.Rest.Transform;

namespace si730pc2u202114900.API.Observability.Presentation.Controller
{
    [Route("api/v1/thing-states")]
    [AllowAnonymous]
    [ProducesResponseType(200)]
    [ProducesResponseType(201)]
    [ProducesResponseType(400)]
    [ProducesResponseType(404)]
    [ProducesResponseType(500)]
    [ApiController]
    public class ThingStateController : ControllerBase
    {
        private readonly IThingStateCommandService _thingStateCommandService;
        private readonly IThingStateRepository _thingStateRepository;

        public ThingStateController(IThingStateCommandService thingStateCommandService,
            IThingStateRepository thingStateRepository)
        {
            _thingStateCommandService = thingStateCommandService;
            _thingStateRepository = thingStateRepository;
        }

        // POST api/v1/thing-states
        [HttpPost]
        public async Task<IActionResult> CreateThingState([FromBody] CreateThingStateResource createThingStateResource)
        {
            try
            {
                var createThingStateCommand =
                    CreateThingStateCommandFromResourceAssembler.ToCommandFromResource(createThingStateResource);
                
                var thingState = await _thingStateCommandService.Handle(createThingStateCommand);
                
                if (thingState is null)
                {
                    return BadRequest("Could not create thing state.");
                }
                var resource = ThingStateResourceFromEntityAssembler.ToResourceFromEntity(thingState);
                return CreatedAtAction(nameof(CreateThingState), resource);
            }
            catch (Exception e)
            {
                return BadRequest(e.Message);
            }
        }
    }
}
