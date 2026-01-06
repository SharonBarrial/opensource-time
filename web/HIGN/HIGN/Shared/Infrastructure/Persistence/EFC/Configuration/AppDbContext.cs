using HIGN.Assessment.Domain.Model.Aggregates;
using HIGN.Personnel.Domain.Model.Aggregates;
using HIGN.Personnel.Domain.Model.ValueObjects;
using HIGN.Shared.Infrastructure.Persistence.EFC.Configuration.Extensions;
using Microsoft.EntityFrameworkCore;

namespace HIGN.Shared.Infrastructure.Persistence.EFC.Configuration;

public class AppDbContext(DbContextOptions<AppDbContext> options) : DbContext(options)
{
    public DbSet<Examiner> Examiners { get; set; }
    public DbSet<MentalStateExam> MentalStateExams { get; set; }
    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        if (!optionsBuilder.IsConfigured)
        {
            throw new InvalidOperationException("No database provider has been configured for this context.");
        }
        base.OnConfiguring(optionsBuilder);
    }
    
    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        
        base.OnModelCreating(modelBuilder);
        modelBuilder.Entity<Examiner>().ToTable("examiners");
        modelBuilder.Entity<Examiner>().HasKey(e => e.Id);
        modelBuilder.Entity<Examiner>().Property(e => e.Id).ValueGeneratedOnAdd();
        modelBuilder.Entity<Examiner>().Property(e => e.FirstName).IsRequired();
        modelBuilder.Entity<Examiner>().Property(e => e.LastName).IsRequired();
        modelBuilder.Entity<Examiner>().Property(e => e.CreatedDate).IsRequired();
        modelBuilder.Entity<Examiner>().Property(e => e.UpdatedDate);
        modelBuilder.Entity<Examiner>().OwnsOne<NationalProvideIdentifier>(npi => npi.NationalProvideIdentifierValueObj, ex =>
        {
            ex.WithOwner().HasForeignKey("Id");
            ex.Property(npi => npi.Value).HasColumnName("NationalProviderIdentifier");
        });
        
        modelBuilder.Entity<MentalStateExam>().ToTable("mental_state_exams");
        modelBuilder.Entity<MentalStateExam>().HasKey(e => e.Id);
        modelBuilder.Entity<MentalStateExam>().Property(e => e.Id).ValueGeneratedOnAdd();
        modelBuilder.Entity<MentalStateExam>().Property(e => e.PatientId).IsRequired();
        modelBuilder.Entity<MentalStateExam>().Property(e => e.ExamDate).IsRequired();
        modelBuilder.Entity<MentalStateExam>().Property(e => e.OrientationScore).IsRequired();
        modelBuilder.Entity<MentalStateExam>().Property(e => e.RegistrationScore).IsRequired();
        modelBuilder.Entity<MentalStateExam>().Property(e => e.AttentionAndCalculationScore).IsRequired();
        modelBuilder.Entity<MentalStateExam>().Property(e => e.RecallScore).IsRequired();
        modelBuilder.Entity<MentalStateExam>().Property(e => e.LanguageScore).IsRequired();
        modelBuilder.Entity<MentalStateExam>().Property(e => e.ExaminerId).IsRequired();
        modelBuilder.Entity<MentalStateExam>().Property(e => e.CreatedDate).IsRequired();
        modelBuilder.Entity<MentalStateExam>().Property(e => e.UpdatedDate);
        modelBuilder.Entity<MentalStateExam>().OwnsOne<NationalProvideIdentifier>(
            npi => npi.NationalProvideIdentifierValueObject,
            mse =>
            {
                mse.WithOwner().HasForeignKey("Id");
                mse.Property(npi => npi.Value).HasColumnName("NationalProviderIdentifier");
            });
        modelBuilder.Entity<MentalStateExam>().HasOne(m => m.Examiner).WithMany(e => e.MentalStateExams).HasForeignKey(m => m.ExaminerId);
        modelBuilder.UseSnakeCaseWithPluralizedTableNamingConvention();
    }
}