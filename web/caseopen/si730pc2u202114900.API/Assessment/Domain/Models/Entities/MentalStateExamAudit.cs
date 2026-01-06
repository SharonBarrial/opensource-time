using System.ComponentModel.DataAnnotations.Schema;
using EntityFrameworkCore.CreatedUpdatedDate.Contracts;

namespace si730pc2u202114900.API.Assessment.Domain.Models.Entities;

/**
 * <summary>
 * Represents an audit record for a mental state exam. This class implements the IEntityWithCreatedUpdatedDate interface.
 * It contains properties for the creation and update timestamps of the exam.
 * </summary>
 * <author>
 * Sharon Antuanet Ivet Barrial Marin
 * - Code Student: u202114900
 * </author>
 * <version>1.0.0</version>
 */
public partial class MentalStateExamAudit :IEntityWithCreatedUpdatedDate
{
    [Column("CreatedAt")]
    public DateTimeOffset? CreatedDate { get;  set; }
    
    [Column("UpdatedAt")]
    public DateTimeOffset? UpdatedDate { get;  set; }
    
}