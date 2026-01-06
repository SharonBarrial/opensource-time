using System.Net.Mime;
using HIGN.Personnel.Domain.Services;
using HIGN.Personnel.Interfaces.REST.Resources;
using HIGN.Personnel.Interfaces.REST.Transform;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace HIGN.Personnel.Interfaces.REST;

[ApiController]
[Route("/api/v1/[controller]")]
[AllowAnonymous]
[Produces(MediaTypeNames.Application.Json)]
[ProducesResponseType(201)]
[ProducesResponseType(400)]
[ProducesResponseType(500)]
public class ExaminerController(IExaminerCommandService examinerCommandService) : ControllerBase
{
    [HttpPost]
    public async Task<IActionResult> CreateExaminer([FromBody] CreateExaminerResource createExaminerResource)
    {
        var command = CreateExaminerCommandFromResourceAssembler.ToCommandFromResource(createExaminerResource);
        var examiner = await examinerCommandService.Handle(command);
        var examinerResource = ExaminerResourceFromEntityAssembler.ToResourceFromEntity(examiner);
        return StatusCode(201, examinerResource);
    }
}