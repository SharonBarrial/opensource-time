using Microsoft.AspNetCore.Mvc;
using si730ebu202317002.API.personnel.Domain.Repositories;
using si730ebu202317002.API.personnel.Domain.Services;
using si730ebu202317002.API.personnel.Interfaces.Rest.Resources;
using si730ebu202317002.API.personnel.Interfaces.Rest.Transform;

namespace si730ebu202317002.API.personnel.Interfaces.Rest;

[ApiController]
[Route("api/v1/[controller]")]
public class ExaminersController : ControllerBase
{
    private readonly IExaminerCommandService _examinerCommandService;
    private readonly IExaminerRepository _examinerRepository;

    public ExaminersController(IExaminerCommandService examinerCommandService, IExaminerRepository examinerRepository)
    {
        _examinerCommandService = examinerCommandService;
        _examinerRepository = examinerRepository;
    }
    
    [HttpPost]
    public async Task<IActionResult> CreateExaminer([FromBody] CreateExaminerResource createExaminerResource)
    {
        // Validamos que no exista un examinador con el mismo NationalProviderIdentifier
        var existsExaminer =
            await _examinerRepository.ExistsExaminerWithNationalProviderIdentifierAsync(createExaminerResource.NationalProviderIdentifier);
        if (existsExaminer) return BadRequest("Ya existe un examinador con el mismo NationalProviderIdentifier.");
        
        var createExaminerCommand =
            CreateExaminerCommandFromResourceAssembler.ToCommandFromResource(createExaminerResource);
        var examiner = await _examinerCommandService.Handle(createExaminerCommand);
        if (examiner is null) return BadRequest();
        
        var resource = ExaminerResourceFromEntityAssembler.ToResourceFromEntity(examiner);
        return CreatedAtAction(nameof(CreateExaminer), resource);
    }
}