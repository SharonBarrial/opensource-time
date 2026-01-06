using System.Data;
using System.Net;
using HIGN.Assessment.Domain.Model.Exceptions;
using HIGN.Personnel.Domain.Model.Exceptions;

namespace HIGN.Shared.Interfaces.Middleware;

public class ErrorHandlerMiddleware
{
    private readonly RequestDelegate _next;

    public ErrorHandlerMiddleware(RequestDelegate next)
    {
        _next = next;
    }


    public async Task Invoke(HttpContext context)
    {
        try
        {
            await _next(context);
        }
        catch (Exception ex)
        {
            await HandleExceptionAsync(context, ex);
        }
    }

    private async Task HandleExceptionAsync(HttpContext context, Exception ex)
    {
        var code = HttpStatusCode.InternalServerError;
        var result = ex.Message;

        if (ex is ExaminerIdNotFoundException)
        {
            code = HttpStatusCode.NotFound;
        }

        if (ex is RecallScoreCannotBeLessThanZeroOrGreaterThanThreeException 
            || ex is LanguageScoreCannotBeLessThanZeroOrGreaterThanNineException 
                                                                             
            || ex is OrientationScoreCannotBeLessThanZeroOrGreaterThanTenException || ex is RegistrationScoreCannotBeLessThanZeroOrGreaterThanThreeException || ex is AttentionAndCalculationScoreCannotBeLessThanZeroOrGreaterThanFiveException)
        {
            code = HttpStatusCode.BadRequest;
        }
        
        if (ex is ConstraintException || ex is DuplicateNameException || ex is ExaminerWithThisNationalProviderIdentifierAlreadyExistsException)
        {
            code = HttpStatusCode.Conflict;
        }

        context.Response.ContentType = "application/json";
        context.Response.StatusCode = (int)code;
        await context.Response.WriteAsync(result);
    }
}