using HIGN.Assessment.Application.Internal.OutboundServices.ACL;
using HIGN.Assessment.Domain.Model.Aggregates;
using HIGN.Assessment.Domain.Model.Commands;
using HIGN.Assessment.Domain.Model.Exceptions;
using HIGN.Assessment.Domain.Repositories;
using HIGN.Assessment.Domain.Services;
using HIGN.Shared.Domain.Repositories;

namespace HIGN.Assessment.Application.Internal.CommandServices;

public class MentalStateExamCommandService(IUnitOfWork unitOfWork, IMentalStateExamRepository mentalStateExamRepository, ExternalExaminerService externalExaminerService) : IMentalStateExamCommandService
{
    public async Task<MentalStateExam?> Handle(CreateMentalStateExamCommand command)
    {
        var examinerId = await externalExaminerService.FetchExaminerById(command.ExaminerId);
        if (examinerId == null)
        {
            throw new ExaminerIdNotFoundException();
        }

        if (command.ExamDate.Date > DateTime.Now)
        {
            throw new ExamDateCannotBeInTheFutureException();
        }

        if (command.OrientationScore < 0 || command.OrientationScore > 10)
        {
            throw new OrientationScoreCannotBeLessThanZeroOrGreaterThanTenException();
        }

        if (command.RegistrationScore < 0 || command.RegistrationScore > 3)
        {
            throw new RegistrationScoreCannotBeLessThanZeroOrGreaterThanThreeException();
        }

        if (command.AttentionAndCalculationScore < 0 || command.AttentionAndCalculationScore > 5)
        {
            throw new AttentionAndCalculationScoreCannotBeLessThanZeroOrGreaterThanFiveException();
        }

        if (command.RecallScore < 0 || command.RecallScore >3)
        {
            throw new RecallScoreCannotBeLessThanZeroOrGreaterThanThreeException();
        }

        if (command.LanguageScore < 0 || command.LanguageScore > 9)
        {
            throw new LanguageScoreCannotBeLessThanZeroOrGreaterThanNineException();
        }
        var mentalStateExam = new MentalStateExam(command);
        await mentalStateExamRepository.AddAsync(mentalStateExam);
        await unitOfWork.CompleteAsync();
        return mentalStateExam;
    }
}