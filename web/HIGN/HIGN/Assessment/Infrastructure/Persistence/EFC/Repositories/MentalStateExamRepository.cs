using HIGN.Assessment.Domain.Model.Aggregates;
using HIGN.Assessment.Domain.Repositories;
using HIGN.Shared.Infrastructure.Persistence.EFC.Configuration;
using HIGN.Shared.Infrastructure.Persistence.EFC.Repositories;

namespace HIGN.Assessment.Infrastructure.Persistence.EFC.Repositories;

public class MentalStateExamRepository(AppDbContext context): BaseRepository<MentalStateExam>(context), IMentalStateExamRepository
{
    
}