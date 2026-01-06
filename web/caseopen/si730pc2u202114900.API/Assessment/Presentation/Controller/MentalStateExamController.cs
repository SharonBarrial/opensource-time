using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using si730pc2u202114900.API.Assessment.Domain.Repositories;
using si730pc2u202114900.API.Assessment.Presentation.Rest.Resource;
using si730pc2u202114900.API.Assessment.Presentation.Rest.Transform;
using si730pc2u202114900.API.Assessment.Domain.Services;

namespace si730pc2u202114900.API.Assessment.Presentation.Controller
{
    /// <summary>
    /// Represents the controller for the MentalStateExam entity. This class extends the ControllerBase class.
    /// It contains a route for accessing the controller, allows anonymous access, and defines possible response types.
    /// It also includes a constructor for initializing the controller with a repository and a command service for the MentalStateExam entity.
    /// The controller has a POST method for creating a new mental state exam from a CreateMentalStateExamResource.
    /// </summary>
    /// <author>
    /// Sharon Antuanet Ivet Barrial Marin
    /// Code Student: u202114900
    /// </author>
    /// <version>1.0.0</version>
    [Route("api/v1/mental-state-exams")]
    [AllowAnonymous]
    [ProducesResponseType(200)]
    [ProducesResponseType(201)]
    [ProducesResponseType(400)]
    [ProducesResponseType(404)]
    [ProducesResponseType(409)]
    [ProducesResponseType(500)]
    [ApiController]
    public class MentalStateExamController : ControllerBase
    {
        private readonly IMentalStateExamRepository _mentalStateExamRepository;
        private readonly IMentalStateExamCommandService _mentalStateExamCommandService;
        
        /// <summary>
        /// Initializes a new instance of the MentalStateExamController class with the provided repository and command service.
        /// </summary>
        /// <param name="mentalStateExamRepository">The repository for the MentalStateExam entity.</param>
        /// <param name="mentalStateExamCommandService">The command service for handling the CreateMentalStateExamCommand.</param>
        public MentalStateExamController(IMentalStateExamRepository mentalStateExamRepository, IMentalStateExamCommandService mentalStateExamCommandService) 
        {
            _mentalStateExamRepository = mentalStateExamRepository;
            _mentalStateExamCommandService = mentalStateExamCommandService;
        }

        // POST api/v1/mental-state-exams
        /// <summary>
        /// Creates a new mental state exam from a CreateMentalStateExamResource.
        /// It converts the resource to a command, handles the command to create a new exam, and returns the created exam as a resource.
        /// If the exam could not be created, it returns a bad request response.
        /// </summary>
        /// <remarks>
        /// Sample request:
        ///
        ///     POST api/v1/mental-state-exams
        ///     {
        ///        "patientId": 0,
        ///        "examinerNationalProviderIdentifier": "UUID version 4",
        ///        "examDate": "2024-07-03T19:22:26.259Z",
        ///        "orientationScore": 0,
        ///        "registrationScore": 0,
        ///        "attentionAndCalculationScore": 0,
        ///        "recallScore": 0,
        ///        "languageScore": 0
        ///     }
        ///
        /// </remarks>
        /// <param name="createMentalStateExamResource">The command object containing all necessary data to create an MentalStateExam.</param>
        /// <response code="200">Returns the newly created MentalStateExam.</response>
        /// <response code="201">Returns the newly created MentalStateExam.</response>
        /// <response code="400">If the appointment has invalid property</response>
        /// <response code="404">Error validating data</response>
        /// <response code="409">Error validating data</response>
        /// <response code="500">Unexpected error</response>
        [HttpPost]
        [HttpPost]
        public async Task<IActionResult> CreateMentalStateExam([FromBody] CreateMentalStateExamResource createMentalStateExamResource)
        {
            try
            {
                var createMentalStateExamCommand =
                    CreateMentalStateExamCommandFromResourceAssembler.ToCommandFromResource(createMentalStateExamResource);
                
                var exam = await _mentalStateExamCommandService.Handle(createMentalStateExamCommand);
                
                if (exam is null)
                {
                    return BadRequest("Could not create mental state exam.");
                }
                var resource = MentalStateExamResourceFromEntityAssembler.ToResourceFromEntity(exam);
                return CreatedAtAction(nameof(CreateMentalStateExam), resource);
            }
            catch (Exception e)
            {
                return BadRequest(e.Message);
            }
        }
    }
}