using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using si730pc2u202114900.API.Personnel.Domain.Repositories;
using si730pc2u202114900.API.Personnel.Domain.Services;
using si730pc2u202114900.API.Personnel.Presentation.Rest.Resources;
using si730pc2u202114900.API.Personnel.Presentation.Rest.Transform;

namespace si730pc2u202114900.API.Personnel.Presentation.Controller
{
    [Route("api/v1/examiners")]
    [AllowAnonymous]
    [ProducesResponseType(200)]
    [ProducesResponseType(201)]
    [ProducesResponseType(400)]
    [ProducesResponseType(404)]
    [ProducesResponseType(500)]
    [ApiController]
    public class ExaminerController : ControllerBase
    {
        private readonly IExaminerCommandService _examinerCommandService;
        private readonly IExaminerRepository _examinerRepository;

        public ExaminerController(IExaminerCommandService examinerCommandService,
            IExaminerRepository examinerRepository)
        {
            _examinerCommandService = examinerCommandService;
            _examinerRepository = examinerRepository;
        }

        // POST api/v1/examiners
        [HttpPost]
        public async Task<IActionResult> CreateExaminer([FromBody] CreateExaminerResource createExaminerResource)
        {
            if (!ModelState.IsValid) return BadRequest(ModelState);
            try
            {
                var command = CreateExaminerCommandFromResourceAssembler.ToCommandFromResource(createExaminerResource);
                var examiner = await _examinerCommandService.Handle(command);
                var examinerResource = ExaminerResourceFromEntityAssembler.ToResourceFromEntity(examiner);
                return StatusCode(201, examinerResource);
            }
            catch (Exception e)
            {
                return BadRequest(e.Message);
            }
        }
    }
}
