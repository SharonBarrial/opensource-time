using EntityFrameworkCore.CreatedUpdatedDate.Contracts;

namespace HIGN.Personnel.Domain.Model.Aggregates;

public partial class Examiner : IEntityWithCreatedUpdatedDate
{
    public DateTimeOffset? CreatedDate { get; set; }
    public DateTimeOffset? UpdatedDate { get; set; }
}