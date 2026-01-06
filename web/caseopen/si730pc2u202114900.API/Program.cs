using System.Reflection;
using Microsoft.EntityFrameworkCore;
using Microsoft.OpenApi.Models;
using si730pc2u202114900.API.Assessment.Application.Internal.Commands;
using si730pc2u202114900.API.Assessment.Domain.Repositories;
using si730pc2u202114900.API.Assessment.Domain.Services;
using si730pc2u202114900.API.Assessment.Infrastructure.Repositories;
using si730pc2u202114900.API.Personnel.Application.Internal.CommandServices;
using si730pc2u202114900.API.Personnel.Domain.Repositories;
using si730pc2u202114900.API.Personnel.Domain.Services;
using si730pc2u202114900.API.Personnel.Infrastructure.Repositories;
using si730pc2u202114900.API.Personnel.Presentation.ACL.Services;
using si730pc2u202114900.API.Shared.Domain.Repositories;
using si730pc2u202114900.API.Shared.Infrastructure.Persistence.EFC.Configuration;
using si730pc2u202114900.API.Shared.Infrastructure.Persistence.EFC.Repositories;
using si730pc2u202114900.API.Shared.Interfaces.ASP.Configuration;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddControllers(configure => configure.Conventions.Add(new KebabCaseRouteNamingConvention()));

// Add Database Connection
var connectionString = builder.Configuration.GetConnectionString("DefaultConnection");

// Configure Database Context and Logging Levels
builder.Services.AddDbContext<AppDbContext>(
    options =>
    {
        if (connectionString != null)
        {
            if (builder.Environment.IsDevelopment())
            {
                options.UseMySQL(connectionString)
                    .LogTo(Console.WriteLine, LogLevel.Information)
                    .EnableDetailedErrors()
                    .EnableSensitiveDataLogging();
            }
            else if (builder.Environment.IsProduction())
            {
                options.UseMySQL(connectionString)
                    .LogTo(Console.WriteLine, LogLevel.Information);
            }
        }
    });

// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen(
    c =>
    {
        c.SwaggerDoc("v1", new OpenApiInfo
            {
                Title = "si730pc2u202114900.API",
                Version = "v1",
                Description = "An ASP.NET Core Web API for managing Mental State Exams. " +
                              "Created by Sharon Barrial, a software engineering student of UPC " +
                              "with a code student: u202114900.",
                TermsOfService = new Uri("https://acme-learning.com/tos"),
                Contact = new OpenApiContact
                {
                    Name = "Sharon Barrial",
                    Email = "u202114900@upc.edu.pe",
                    Url = new Uri("https://www.linkedin.com/in/sharon-barrial-689a4a233/")
                },
                License = new OpenApiLicense
                {
                    Name = "Apache 2.0",
                    Url = new Uri("https://www.apache.org/licenses/LICENSE-2.0.html")
                }
            });
        c.EnableAnnotations();
        
        var xmlFilename = $"{Assembly.GetExecutingAssembly().GetName().Name}.xml";
        c.IncludeXmlComments(Path.Combine(AppContext.BaseDirectory, xmlFilename));
    });


// Configure Lowercase Urls
builder.Services.AddRouting(options => options.LowercaseUrls = true);

// Add CORS Policy
builder.Services.AddCors(options =>
{
    options.AddPolicy("AllowAllPolicy",
        policy => policy.AllowAnyOrigin()
            .AllowAnyMethod()
            .AllowAnyHeader());
});

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
if (app.Environment.IsDevelopment()|| app.Environment.IsProduction())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseCors("AllowAllPolicy");

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();


app.Run();