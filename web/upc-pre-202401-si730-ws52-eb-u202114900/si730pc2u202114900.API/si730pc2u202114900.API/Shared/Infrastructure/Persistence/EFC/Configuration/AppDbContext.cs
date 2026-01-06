using si730pc2u202114900.API.Shared.Infrastructure.Persistence.EFC.Configuration.Extensions;
using EntityFrameworkCore.CreatedUpdatedDate.Extensions;
using Microsoft.EntityFrameworkCore;
using si730pc2u202114900.API.Inventory.Domain.Models.Entities;
using si730pc2u202114900.API.Observability.Domain.Models.Entities;

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

        // Thing Context
        builder.Entity<Thing>().ToTable("Thing");
        builder.Entity<Thing>().HasKey(t => t.Id);
        builder.Entity<Thing>().Property(t => t.SerialNumber).IsRequired();
        builder.Entity<Thing>().Property(t => t.Model).IsRequired();
        builder.Entity<Thing>().Property(t => t.OperationMode).IsRequired();
        builder.Entity<Thing>().Property(t => t.MaximumTemperatureThreshold).IsRequired();
        builder.Entity<Thing>().Property(t => t.MinimumHumidityThreshold).IsRequired();
        builder.Entity<Thing>().Property(t => t.CreatedDate);
        builder.Entity<Thing>().Property(t => t.UpdatedDate);
        // Ensure Serial Number is unique
        builder.Entity<Thing>()
            .HasIndex(e => e.SerialNumber)
            .IsUnique();
        builder.Entity<Thing>().Property(e=> e.CreatedDate);
        builder.Entity<Thing>().Property(e=> e.UpdatedDate);
        
        // ThingState Context
        builder.Entity<ThingState>().ToTable("ThingState");
        builder.Entity<ThingState>().HasKey(m => m.Id);
        builder.Entity<ThingState>().Property(m => m.ThingSerialNumber).IsRequired();
        builder.Entity<ThingState>().Property(m => m.CurrentOperationMode).IsRequired();
        builder.Entity<ThingState>().Property(m => m.CurrentTemperature).IsRequired();
        builder.Entity<ThingState>().Property(m => m.CurrentHumidity).IsRequired();
        builder.Entity<ThingState>().Property(m => m.CollectedAt).IsRequired();
        // Ensure ThingSerialNumber is unique
        builder.Entity<ThingState>()
            .HasIndex(e => e.ThingSerialNumber)
            .IsUnique();
        builder.Entity<ThingState>().Property(e=> e.CreatedDate);
        builder.Entity<ThingState>().Property(e=> e.UpdatedDate);
        
        

        // Apply SnakeCase Naming Convention
        builder.UseSnakeCaseWithPluralizedTableNamingConvention();
    }
    
}