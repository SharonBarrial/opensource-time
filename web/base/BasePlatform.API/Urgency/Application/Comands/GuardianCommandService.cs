using BasePlatform.API.Shared.Domain.Repositories;
using BasePlatform.API.Urgency.Domain;
using BasePlatform.API.Urgency.Domain.Models.Commands;
using BasePlatform.API.Urgency.Domain.Models.Entities;
using BasePlatform.API.Urgency.Domain.Repositories;

namespace BasePlatform.API.Urgency.Application.Comands;

public class GuardianCommandService : IGuardianCommandService
{
    private readonly IGuardianRepository _guardianRepository;
    private readonly IUnitOfWork _unitOfWork;
    
    public GuardianCommandService(IGuardianRepository guardianRepository,IUnitOfWork unitOfWork)
    {
        _guardianRepository = guardianRepository;
        _unitOfWork = unitOfWork;
    }
    
    public async Task<int> handle(CreatedGuardianCommand command)
    {
        // Create a new guardian
        var guardian = new Guardian()
        {
            Username = command.Username,
            Email = command.Email,
            FirstName = command.FirstName,
            LastName = command.LastName,
            Gender = command.Gender,
            Address = command.Address
        };

        //No permitido por el rendimiento
        //var guardians = await _guardianRepository.ListAsync(); //2 Million guardians select * from Guardian
        
        // Opcion optimazada y unica válida
        var guardians = await _guardianRepository.GetGuardiansByUsername(guardian.Username);//2 Million guardians select * from Guardian where username = 'guardian.Username'
        var existingGuardian = guardians.FirstOrDefault(g => g.Username == guardian.Username);
        
        if(existingGuardian != null)
            throw new Exception("username Guardian already exists");
        
        await _guardianRepository.AddAsync(guardian);
        await _unitOfWork.CompleteAsync();

        return guardian.Id;
    }
}