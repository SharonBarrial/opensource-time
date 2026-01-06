using si730ebu202317002.API.assessment.Domain.Model.Aggregates;
using si730ebu202317002.API.assessment.Domain.Model.Commands;
using si730ebu202317002.API.assessment.Domain.Repositories;
using si730ebu202317002.API.assessment.Domain.Services;
using si730ebu202317002.API.personnel.Domain.Services;
using si730ebu202317002.API.Shared.Domain.Repositories;

namespace si730ebu202317002.API.assessment.Application.Internal.CommandServices;

public class MentalStateExamCommandService : IMentalStateExamCommandService
{
    private readonly IMentalStateExamRepository _mentalStateExamRepository;
    private readonly IExaminerACLService _examinerACLService;
    private readonly IUnitOfWork _unitOfWork;

    public MentalStateExamCommandService(
        IMentalStateExamRepository mentalStateExamRepository,
        IExaminerACLService examinerACLService,
        IUnitOfWork unitOfWork)
    {
        _mentalStateExamRepository = mentalStateExamRepository;
        _examinerACLService = examinerACLService;
        _unitOfWork = unitOfWork;
    }

    public async Task<MentalStateExam?> Handle(CreateMentalStateExamCommand command)
    {
        bool examinerExists = await _examinerACLService.ExistsExaminerAsync(command.ExaminerNationalProviderIdentifier);
        if (!examinerExists)
        {
            throw new Exception("Examiner does not exist");
        }

        if (command.ExamDate > DateTime.Now)
        {
            throw new Exception("Exam date cannot be in the future");
        }

        var exam = new MentalStateExam(command);
        await _mentalStateExamRepository.AddAsync(exam);
        await _unitOfWork.CompleteAsync();
        return exam;
    }
}