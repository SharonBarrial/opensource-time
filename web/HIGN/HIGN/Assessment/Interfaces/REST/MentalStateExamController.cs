using System.Net.Mime;
using HIGN.Assessment.Domain.Services;
using HIGN.Assessment.Interfaces.REST.Resources;
using HIGN.Assessment.Interfaces.REST.Transform;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace HIGN.Assessment.Interfaces.REST;

[ApiController]
[Route("/api/v1/[controller]")]
[AllowAnonymous]
[Produces(MediaTypeNames.Application.Json)]
[ProducesResponseType(201)]
[ProducesResponseType(400)]
[ProducesResponseType(404)]
[ProducesResponseType(500)]
public class MentalStateExamController(IMentalStateExamCommandService mentalStateExamCommandService) : ControllerBase
{
    [HttpPost]
    public async Task<IActionResult> CreateMentalStateExam([FromBody] CreateMentalStateExamResource createMentalStateExamResource)
    {
        var command = CreateMentalStateExamCommandFromResourceAssembler.ToCommandFromResource(createMentalStateExamResource);
        var mentalStateExam = await mentalStateExamCommandService.Handle(command);
        var mentalStateExamResource = MentalStateExamResourceFromEntityAssembler.ToResourceFromEntity(mentalStateExam);
        return StatusCode(201, mentalStateExamResource);
    }
}