using si730ebu202317002.API.personnel.Domain.Model.Aggregates;
using si730ebu202317002.API.personnel.Domain.Model.Commands;
using si730ebu202317002.API.personnel.Domain.Repositories;
using si730ebu202317002.API.personnel.Domain.Services;
namespace si730ebu202317002.API.personnel.Application.Internal.CommandServices;

using si730ebu202317002.API.Shared.Domain.Repositories;

public class ExaminerCommandService : IExaminerCommandService
{
    private readonly IExaminerRepository _examinerRepository;
    private readonly IUnitOfWork _unitOfWork;

    public ExaminerCommandService(IExaminerRepository examinerRepository, IUnitOfWork unitOfWork)
    {
        _examinerRepository = examinerRepository;
        _unitOfWork = unitOfWork;
    }

    public async Task<Examiner?> Handle(CreateExaminerCommand command)
    {
        bool examinerExists = await _examinerRepository.ExistsExaminerWithNationalProviderIdentifierAsync(command.NationalProviderIdentifier);
        if (examinerExists)
        {
            throw new Exception("Examiner already exists");
        }
        var examiner = new Examiner(command);
        await _examinerRepository.AddAsync(examiner);
        await _unitOfWork.CompleteAsync();
        return examiner;
    }
}