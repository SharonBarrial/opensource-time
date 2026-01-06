using si730pc2u202114900.API.Shared.Infrastructure.Persistence.EFC.Configuration.Extensions;
using EntityFrameworkCore.CreatedUpdatedDate.Extensions;
using Microsoft.EntityFrameworkCore;
using si730pc2u202114900.API.Assessment.Domain.Models.Entities;
using si730pc2u202114900.API.Personnel.Domain.Models.Entities;

namespace si730pc2u202114900.API.Shared.Infrastructure.Persistence.EFC.Configuration;

public class AppDbContext(DbContextOptions options) : DbContext(options)
{
    protected override void OnConfiguring(DbContextOptionsBuilder builder)
    {
        base.OnConfiguring(builder);
        // Enable Audit Fields Interceptors
        builder.AddCreatedUpdatedInterceptor();
    }

    protected override void OnModelCreating(ModelBuilder builder)
    {
        base.OnModelCreating(builder);

        // Examiner Context
        builder.Entity<Examiner>().ToTable("Examiner");
        builder.Entity<Examiner>().HasKey(e => e.Id);
        builder.Entity<Examiner>().Property(e => e.FirstName).IsRequired();
        builder.Entity<Examiner>().Property(e => e.LastName).IsRequired();
        builder.Entity<Examiner>().Property(e => e.NationalProviderIdentifier).IsRequired();
        // Ensure nationalProviderIdentifier is unique
        builder.Entity<Examiner>()
            .HasIndex(e => e.NationalProviderIdentifier)
            .IsUnique();
        builder.Entity<Examiner>().Property(e=> e.CreatedDate);
        builder.Entity<Examiner>().Property(e=> e.UpdatedDate);
        
        // MentalStateExam Context
        builder.Entity<MentalStateExam>().ToTable("MentalStateExam");
        builder.Entity<MentalStateExam>().HasKey(m => m.Id);
        builder.Entity<MentalStateExam>().Property(m => m.PatientId).IsRequired();
        builder.Entity<MentalStateExam>().Property(m => m.ExaminerNationalProviderIdentifier).IsRequired();
        // Ensure examinerNationalProviderIdentifier is unique
        builder.Entity<MentalStateExam>()
            .HasIndex(m => m.ExaminerNationalProviderIdentifier)
            .IsUnique();
        builder.Entity<MentalStateExam>().Property(m => m.ExamDate).IsRequired();
        builder.Entity<MentalStateExam>().Property(m => m.OrientationScore).IsRequired();
        builder.Entity<MentalStateExam>().Property(m => m.RegistrationScore).IsRequired();
        builder.Entity<MentalStateExam>().Property(m => m.AttentionAndCalculationScore).IsRequired();
        builder.Entity<MentalStateExam>().Property(m => m.RecallScore).IsRequired();
        builder.Entity<MentalStateExam>().Property(m => m.LanguageScore).IsRequired();
        

        // Apply SnakeCase Naming Convention
        builder.UseSnakeCaseWithPluralizedTableNamingConvention();
    }
    
}