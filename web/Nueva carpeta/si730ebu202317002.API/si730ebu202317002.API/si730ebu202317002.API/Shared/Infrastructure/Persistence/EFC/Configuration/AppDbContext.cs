using si730ebu202317002.API.Shared.Infrastructure.Persistence.EFC.Configuration.Extensions;
using EntityFrameworkCore.CreatedUpdatedDate.Extensions;
using Microsoft.EntityFrameworkCore;
using si730ebu202317002.API.assessment.Domain.Model.Aggregates;
using si730ebu202317002.API.personnel.Domain.Model.Aggregates;

namespace si730ebu202317002.API.Shared.Infrastructure.Persistence.EFC.Configuration;

public class AppDbContext(DbContextOptions options) : DbContext(options)
{
    
    protected override void OnConfiguring(DbContextOptionsBuilder builder)
    {
        base.OnConfiguring(builder);
        // Enable Audit Fields Interceptors.
        builder.AddCreatedUpdatedInterceptor();
    }

    protected override void OnModelCreating(ModelBuilder builder)
    {
        base.OnModelCreating(builder);
        
        // Examiner Context
        builder.Entity<Examiner>().HasKey(e => e.Id);
        builder.Entity<Examiner>().Property(e => e.Id)
            .IsRequired()
            .ValueGeneratedOnAdd();
        builder.Entity<Examiner>().Property(e => e.firstName)
            .IsRequired();
        builder.Entity<Examiner>().Property(e => e.lastName)
            .IsRequired();
        builder.Entity<Examiner>().Property(e => e.nationalProviderIdentifier)
            .IsRequired();
        // Ensure nationalProviderIdentifier is unique
        builder.Entity<Examiner>()
            .HasIndex(e => e.nationalProviderIdentifier)
            .IsUnique();
        
        // MentalStateExam Context
        builder.Entity<MentalStateExam>().HasKey(m => m.Id);
        builder.Entity<MentalStateExam>().Property(m => m.Id)
            .IsRequired()
            .ValueGeneratedOnAdd();
        builder.Entity<MentalStateExam>().Property(m => m.PatientId)
            .IsRequired();
        builder.Entity<MentalStateExam>().Property(m => m.ExaminerNationalProviderIdentifier)
            .IsRequired();
        builder.Entity<MentalStateExam>().Property(m => m.ExamDate)
            .IsRequired();
        builder.Entity<MentalStateExam>().Property(m => m.OrientationScore)
            .IsRequired();
        builder.Entity<MentalStateExam>().Property(m => m.RegistrationScore)
            .IsRequired();
        builder.Entity<MentalStateExam>().Property(m => m.AttentionAndCalculationScore)
            .IsRequired();
        builder.Entity<MentalStateExam>().Property(m => m.RecallScore)
            .IsRequired();
        builder.Entity<MentalStateExam>().Property(m => m.LanguageScore)
            .IsRequired();
        
        // Apply SnakeCase Naming Convention
        builder.UseSnakeCaseWithPluralizedTableNamingConvention();
    }
}