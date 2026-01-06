using BasePlatform.API.Shared.Infrastructure.Persistence.EFC.Configuration.Extensions;
using BasePlatform.API.Urgency.Domain.Models.Entities;
using EntityFrameworkCore.CreatedUpdatedDate.Extensions;
using Microsoft.EntityFrameworkCore;

namespace BasePlatform.API.Shared.Infrastructure.Persistence.EFC.Configuration;

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

        builder.Entity<Guardian>().ToTable("Guardian");
        builder.Entity<Guardian>().HasKey(g => g.Id);
        builder.Entity<Guardian>().Property(g => g.Username).HasMaxLength(30);
        
        // Apply SnakeCase Naming Convention
        builder.UseSnakeCaseWithPluralizedTableNamingConvention();
    }
}