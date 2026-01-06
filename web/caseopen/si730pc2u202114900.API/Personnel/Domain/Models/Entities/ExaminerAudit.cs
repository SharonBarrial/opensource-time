using System.ComponentModel.DataAnnotations.Schema;
using EntityFrameworkCore.CreatedUpdatedDate.Contracts;

namespace si730pc2u202114900.API.Personnel.Domain.Models.Entities;

public class ExaminerAudit: IEntityWithCreatedUpdatedDate
{
    [Column("CreatedAt")]public DateTimeOffset? CreatedDate { get; set; }
    [Column("UpdateAt")]public DateTimeOffset? UpdatedDate { get; set; }
}