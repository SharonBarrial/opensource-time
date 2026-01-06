using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using si730pc2u202114900.API.Inventory.Domain.Models.Entities;
using si730pc2u202114900.API.Inventory.Domain.Repositories;
using si730pc2u202114900.API.Inventory.Domain.Services;
using si730pc2u202114900.API.Inventory.Presentation.Rest.Resource;
using si730pc2u202114900.API.Inventory.Presentation.Rest.Transform;

namespace si730pc2u202114900.API.Assessment.Presentation.Controller
{
    /// <summary>
    /// Represents the controller for the Thing entity. This class extends the ControllerBase class.
    /// It contains a route for accessing the controller, allows anonymous access, and defines possible response types.
    /// It also includes a constructor for initializing the controller with a repository and a command service for the Thing entity.
    /// The controller has a POST method for creating a new mental state exam from a CreateThingStateResource.
    /// </summary>
    /// <author>
    /// Sharon Antuanet Ivet Barrial Marin
    /// Code Student: u202114900
    /// </author>
    /// <version>1.0.0</version>
    [Route("api/v1/things")]
    [AllowAnonymous]
    [ProducesResponseType(200)]
    [ProducesResponseType(201)]
    [ProducesResponseType(400)]
    [ProducesResponseType(404)]
    [ProducesResponseType(409)]
    [ProducesResponseType(500)]
    [ApiController]
    public class ThingController : ControllerBase
    {
        private readonly IThingRepository _thingRepository;
        private readonly IThingCommandService _thingCommandService;
        
        /// <summary>
        /// Initializes a new instance of the ThingController class with the provided repository and command service.
        /// </summary>
        /// <param name="thingRepository">The repository for the Thing entity.</param>
        /// <param name="thingCommandService">The command service for handling the CreateThingCommand.</param>
        public ThingController(IThingRepository thingRepository, IThingCommandService thingCommandService) 
        {
            _thingRepository = thingRepository;
            _thingCommandService = thingCommandService;
        }

        // POST api/v1/things
        /// <summary>
        /// Creates a new thing from a CreateThingStateResource.
        /// It converts the resource to a command, handles the command to create a new Thing, and returns the created thing as a resource.
        /// If thing could not be created, it returns a bad request response.
        /// </summary>
        /// <remarks>
        /// Sample request:
        ///
        ///     POST api/v1/things
        ///     {
        ///        "serialNumber": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
        ///        "model": "string",
        ///        "operationMode": 0,
        ///        "maximumTemperatureThreshold": 0,
        ///        "minimumHumidityThreshold": 0
        ///     }
        ///
        /// </remarks>
        /// <param name="createThingResource">The command object containing all necessary data to create a Thing.</param>
        /// <response code="200">Returns the newly created Thing.</response>
        /// <response code="201">Returns the newly created Thing.</response>
        /// <response code="400">If the appointment has invalid property</response>
        /// <response code="404">Error validating data</response>
        /// <response code="409">Error validating data</response>
        /// <response code="500">Unexpected error</response>
        [HttpPost]
        
        public async Task<IActionResult> CreateThing([FromBody] CreateThingResource createThingResource)
        {
            if (!ModelState.IsValid) return BadRequest(ModelState);
            try
            {
                var command = CreateThingCommandFromResourceAssembler.ToCommandFromResource(createThingResource);
                var thing = await _thingCommandService.Handle(command);
                var thingResource = ThingResourceFromEntityAssembler.ToResourceFromEntity(thing);
                return StatusCode(201, thingResource);
            }
            catch (Exception e)
            {
                return BadRequest(e.Message);
            }
        }
        
        // GET api/v1/things
        /// <summary>
        /// Gets all things created from the repository.
        /// </summary>
        /// <remarks>
        /// Sample Request:
        ///
        ///     GET /api/v1/things
        ///
        /// </remarks>
        /// <returns>A list of things created</returns>
        /// <response code="200">Return a list of things created.</response>
        /// <response code="500">Server Error Internal</response>
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Thing>>> GetThings()
        {
            var things = await _thingRepository.ListAsync();
            return Ok(things);
        }
    }
}