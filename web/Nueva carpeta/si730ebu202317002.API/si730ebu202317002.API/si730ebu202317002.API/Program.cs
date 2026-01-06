


using Microsoft.EntityFrameworkCore;
using Microsoft.OpenApi.Models;
using si730ebu202317002.API.assessment.Application.Internal.CommandServices;
using si730ebu202317002.API.assessment.Domain.Repositories;
using si730ebu202317002.API.assessment.Domain.Services;
using si730ebu202317002.API.assessment.Infrastructure.Persitence.EFC.Repositories;
using si730ebu202317002.API.personnel.Application.Internal.CommandServices;
using si730ebu202317002.API.personnel.Domain.Repositories;
using si730ebu202317002.API.personnel.Domain.Services;
using si730ebu202317002.API.personnel.Infrastructure.Persitence.EFC.Repositories;
using si730ebu202317002.API.personnel.Interfaces.ACL.Services;
using si730ebu202317002.API.Shared.Domain.Repositories;
using si730ebu202317002.API.Shared.Infrastructure.Persistence.EFC.Configuration;
using si730ebu202317002.API.Shared.Infrastructure.Persistence.EFC.Repositories;
using si730ebu202317002.API.Shared.Interfaces.ASP.Configuration;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers(options => options.Conventions.Add(new KebabCaseRouteNamingConvention()));

// Add Database Connection
var connectionString = builder.Configuration.GetConnectionString("DefaultConnection");

// Configure Database Context and Logging Levels

builder.Services.AddDbContext<AppDbContext>(
    options =>
    {
        if (connectionString != null)
            if (builder.Environment.IsDevelopment())
                options.UseMySQL(connectionString)
                    .LogTo(Console.WriteLine, LogLevel.Information)
                    .EnableSensitiveDataLogging()
                    .EnableDetailedErrors();
            else if (builder.Environment.IsProduction())
                options.UseMySQL(connectionString)
                    .LogTo(Console.WriteLine, LogLevel.Error)
                    .EnableDetailedErrors();
    });

// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen(
    c =>
    {
        c.SwaggerDoc("v1",
            new OpenApiInfo
            {
                Title = "ACME.LearningCenterPlatform.API",
                Version = "v1",
                Description = "ACME Learning Center Platform API",
                TermsOfService = new Uri("https://acme-learning.com/tos"),
                Contact = new OpenApiContact
                {
                    Name = "ACME Studios",
                    Email = "contact@acme.com"
                },
                License = new OpenApiLicense
                {
                    Name = "Apache 2.0",
                    Url = new Uri("https://www.apache.org/licenses/LICENSE-2.0.html")
                }
            });
        c.EnableAnnotations();
    });

// Configure Lowercase URLs
builder.Services.AddRouting(options => options.LowercaseUrls = true);

// Shared Bounded Context Injection Configuration
builder.Services.AddScoped<IUnitOfWork, UnitOfWork>();
builder.Services.AddScoped<IExaminerRepository, ExaminerRepository>();
builder.Services.AddScoped<IExaminerCommandService, ExaminerCommandService>();
builder.Services.AddScoped<IMentalStateExamRepository, MentalStateExamRepository>();
builder.Services.AddScoped<IMentalStateExamCommandService, MentalStateExamCommandService>();
builder.Services.AddScoped<IExaminerACLService, ExaminerACLService>();




var app = builder.Build();

// Verify Database Objects are created
using (var scope = app.Services.CreateScope())
{
    var services = scope.ServiceProvider;
    var context = services.GetRequiredService<AppDbContext>();
    context.Database.EnsureCreated();
}


// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
