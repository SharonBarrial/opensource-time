using System.ComponentModel.DataAnnotations.Schema;
using EntityFrameworkCore.CreatedUpdatedDate.Contracts;

namespace si730ebu202317002.API.personnel.Domain.Model.Aggregates;

public partial class Examiner : IEntityWithCreatedUpdatedDate
{
    
    [Column("CreatedAt")]public DateTimeOffset? CreatedDate { get; set; }
    [Column("UpdateAt")]public DateTimeOffset? UpdatedDate { get; set; }
}
