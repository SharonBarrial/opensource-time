using System.ComponentModel.DataAnnotations.Schema;
using EntityFrameworkCore.CreatedUpdatedDate.Contracts;

namespace si730ebu20221c936.Inventory.Domain.Model.Aggregates;

public partial class Thing: IEntityWithCreatedUpdatedDate
{
    [Column("CollectedAt")]
    public DateTimeOffset? CreatedDate { get; set; }
    public DateTimeOffset? UpdatedDate { get; set; }
}