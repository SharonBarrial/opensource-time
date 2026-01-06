using EntityFrameworkCore.CreatedUpdatedDate.Contracts;

namespace HIGN.Assessment.Domain.Model.Aggregates;

public partial class MentalStateExam : IEntityWithCreatedUpdatedDate
{
    public DateTimeOffset? CreatedDate { get; set; }
    public DateTimeOffset? UpdatedDate { get; set; }
}