using si730pc2u202114900.API.Personnel.Domain.Models.Commands;
using si730pc2u202114900.API.Personnel.Domain.Models.Entities;
using si730pc2u202114900.API.Personnel.Domain.Repositories;
using si730pc2u202114900.API.Personnel.Domain.Services;
using si730pc2u202114900.API.Shared.Domain.Repositories;

namespace si730pc2u202114900.API.Personnel.Application.Internal.CommandServices;

public class ExaminerCommandService : IExaminerCommandService
{
    private readonly IExaminerRepository _examinerRepository;
    private readonly IUnitOfWork _unitOfWork;

    public ExaminerCommandService(IExaminerRepository examinerRepository, IUnitOfWork unitOfWork)
    {
        _examinerRepository = examinerRepository;
        _unitOfWork = unitOfWork;
    }

    /**public async Task<Examiner?> Handle(CreateExaminerCommand command)
    {
        if (command.NationalProviderIdentifier == Guid.Empty)
        {
            throw new ArgumentException("The value provided for NationalProviderIdentifier cannot be an empty Guid.");
        }

        bool examinerExists = await _examinerRepository.ExistsExaminerWithNationalProviderIdentifierAsync(command.NationalProviderIdentifier);
        if (examinerExists)
        {
            throw new InvalidOperationException($"Examiner with the provided National Provider Identifier {command.NationalProviderIdentifier} already exists");
        }

        var examiner = new Examiner(command);
        await _examinerRepository.AddAsync(examiner);
        await _unitOfWork.CompleteAsync();
        return examiner;
    }**/
    
public async Task<Examiner?> Handle(CreateExaminerCommand command)
{
    if (string.IsNullOrEmpty(command.NationalProviderIdentifier))
    {
        throw new ArgumentException("The value provided for NationalProviderIdentifier cannot be empty.");
    }

    if (!Guid.TryParse(command.NationalProviderIdentifier, out Guid nationalProviderIdentifier))
    {
        throw new ArgumentException("The value provided for NationalProviderIdentifier must be a valid GUID with version 4.");
    }

    bool examinerExists =
        await _examinerRepository.ExistsExaminerWithNationalProviderIdentifierAsync(nationalProviderIdentifier.ToString());
    if (examinerExists)
    {
        throw new InvalidOperationException(
            $"Examiner with the provided National Provider Identifier {nationalProviderIdentifier} already exists");
    }

    var examiner = new Examiner(command);
    await _examinerRepository.AddAsync(examiner);
    await _unitOfWork.CompleteAsync();
    return examiner;
}
}