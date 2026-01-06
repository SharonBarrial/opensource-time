using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using si730pc2u202114900.API.Inventory.Domain.Models.Commands;
using si730pc2u202114900.API.Shared;

namespace si730pc2u202114900.API.Inventory.Domain.Models.Entities;

/**
 * <summary>
 * Represents a Thing. This class is a child of the ThingStateAudit class.
 * It contains properties for the exam's ID, patient ID, examiner's national provider identifier, exam date, and scores for various mental state aspects.
 * It also includes a constructor for creating a new mental state exam from a CreateThingCommand.
 * </summary>
 * <author>
 * Sharon Antuanet Ivet Barrial Marin
 * - Code Student: u202114900
 * </author>
 * <version>1.0.0</version>
 */
public class Thing: ThingAudit
{
    public int Id { get; set; }
    [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
    public Guid SerialNumber { get; set; }
    public string Model { get; set; }
    
    public EnumOperationMode.EOperationMode OperationMode { get; set; } = EnumOperationMode.EOperationMode.ScheduleDriven;
    
    [Range(-40.00, 85.00, ErrorMessage = "Maximum temperature threshold must be between -40.00 and 85.00.")]
    public decimal MaximumTemperatureThreshold { get; set; }
    [Range(0.00, 100.00, ErrorMessage = "Minimum humidity threshold must be between 0.00 and 100.00.")]
    public decimal MinimumHumidityThreshold { get; set; }
    
    
    private Thing() { }
    
    /**
     * <summary>
     * Constructs a new Thing from a CreateThingCommand.
     * </summary>
     * <param name="command">The command containing the data for the new Thing.</param>
     */
    public Thing(CreateThingCommand command)
    {
        SerialNumber = command.SerialNumber;
        Model = command.Model;
        OperationMode = command.OperationMode;
        MaximumTemperatureThreshold = command.MaximumTemperatureThreshold;
        MinimumHumidityThreshold = command.MinimumHumidityThreshold;
    }
}