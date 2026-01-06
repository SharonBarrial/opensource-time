using si730pc2u202114900.API.Shared;

namespace si730pc2u202114900.API.Inventory.Domain.Models.Commands;

/**
 * <summary>
 * Represents the command to create a mental state exam. This record is immutable and has value-based equality.
 * </summary>
 * <param name="PatientId">The ID of the patient for whom the exam is being created.</param>
 * <param name="ExaminerNationalProviderIdentifier">The national provider identifier of the examiner conducting the exam.</param>
 * <param name="ExamDate">The date the exam is conducted.</param>
 * <param name="OrientationScore">The score for the patient's orientation.</param>
 * <param name="RegistrationScore">The score for the patient's registration.</param>
 * <param name="AttentionAndCalculationScore">The score for the patient's attention and calculation.</param>
 * <param name="RecallScore">The score for the patient's recall.</param>
 * <param name="LanguageScore">The score for the patient's language skills.</param>
 * <author>
 * Sharon Antuanet Ivet Barrial Marin
 * - Code Student: u202114900
 * </author>
 * <version>1.0.0</version>
 */
public record CreateThingCommand(
    Guid SerialNumber,
    string Model,
    EnumOperationMode.EOperationMode OperationMode,
    decimal MaximumTemperatureThreshold,
    decimal MinimumHumidityThreshold
    );