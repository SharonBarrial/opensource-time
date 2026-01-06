using HIGN.Personnel.Domain.Model.Aggregates;
using HIGN.Personnel.Domain.Model.Commands;
using HIGN.Personnel.Domain.Model.Exceptions;
using HIGN.Personnel.Domain.Repositories;
using HIGN.Personnel.Domain.Services;
using HIGN.Shared.Domain.Repositories;

namespace HIGN.Personnel.Application.Internal.CommandServices;

public class ExaminerCommandService(IUnitOfWork unitOfWork, IExaminerRepository examinerRepository) : IExaminerCommandService
{
    public async Task<Examiner?> Handle(CreateExaminerCommand command)
    {
        if (examinerRepository.ExistsByNationalProviderIdentifier(command.NationalProviderIdentifier))
        {
            throw new ExaminerWithThisNationalProviderIdentifierAlreadyExistsException();
        }
        var examiner = new Examiner(command);
        await examinerRepository.AddAsync(examiner);
        await unitOfWork.CompleteAsync();
        return examiner;
    }
}