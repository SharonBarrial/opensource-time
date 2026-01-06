using Microsoft.AspNetCore.Mvc;
using si730ebu202317002.API.assessment.Domain.Repositories;
using si730ebu202317002.API.assessment.Domain.Services;
using si730ebu202317002.API.assessment.Interfaces.Rest.Resources;
using si730ebu202317002.API.assessment.Interfaces.Rest.Transform;

namespace si730ebu202317002.API.assessment.Interfaces.Rest;

[ApiController]
[Route("api/v1/mental-state-exams")]
public class MentalStateExamsController : ControllerBase
{
    private readonly IMentalStateExamCommandService _mentalStateExamCommandService;

    public MentalStateExamsController(IMentalStateExamCommandService mentalStateExamCommandService)
    {
        _mentalStateExamCommandService = mentalStateExamCommandService;
    }

    [HttpPost]
    public async Task<IActionResult> CreateMentalStateExam([FromBody] CreateMentalStateExamResource createMentalStateExamResource)
    {
        try
        {
            // Convert resource to command
            var createMentalStateExamCommand = 
                CreateMentalStateExamCommandFromResourceAssembler.ToCommandFromResource(createMentalStateExamResource);
                
            // Handle command to create a new exam
            var exam = await _mentalStateExamCommandService.Handle(createMentalStateExamCommand);
                
            // Check if the creation was successful
            if (exam is null)
            {
                return BadRequest("Could not create mental state exam.");
            }

            // Convert entity to resource
            var resource = MentalStateExamResourceFromEntityAssembler.ToResourceFromEntity(exam);
            return CreatedAtAction(nameof(CreateMentalStateExam), resource);
        }
        catch (Exception ex)
        {
            // Return a bad request with the exception message
            return BadRequest(ex.Message);
        }
    }
}