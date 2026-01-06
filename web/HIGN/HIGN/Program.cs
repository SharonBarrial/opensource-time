using HIGN.Assessment.Application.Internal.CommandServices;
using HIGN.Assessment.Application.Internal.OutboundServices.ACL;
using HIGN.Assessment.Domain.Model.Aggregates;
using HIGN.Assessment.Domain.Repositories;
using HIGN.Assessment.Domain.Services;
using HIGN.Assessment.Infrastructure.Persistence.EFC.Repositories;
using HIGN.Personnel.Application.Internal.CommandServices;
using HIGN.Personnel.Application.Internal.QueryServices;
using HIGN.Personnel.Domain.Repositories;
using HIGN.Personnel.Domain.Services;
using HIGN.Personnel.Infrastructure.Persistence.EFC.Repositories;
using HIGN.Personnel.Interfaces.ACL;
using HIGN.Personnel.Interfaces.ACL.Services;
using HIGN.Shared.Domain.Repositories;
using HIGN.Shared.Infrastructure.Persistence.EFC.Configuration;
using HIGN.Shared.Infrastructure.Persistence.EFC.Repositories;
using HIGN.Shared.Interfaces.ASP.Configuration;
using HIGN.Shared.Interfaces.Middleware;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers(configure => configure.Conventions.Add(new KebabCaseRouteNamingConvention()));


var connectionString = builder.Configuration.GetConnectionString("DefaultConnection");

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

// Add services to the container.
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();


builder.Services.AddScoped<IUnitOfWork, UnitOfWork>();
builder.Services.AddScoped<IExaminerRepository, ExaminerRepository>();
builder.Services.AddScoped<IExaminerCommandService, ExaminerCommandService>();
builder.Services.AddScoped<IExaminerContextFacade, ExaminerContextFacade>();
builder.Services.AddScoped<IExaminerQueryService,ExaminerQueryService>();

builder.Services.AddScoped<IMentalStateExamCommandService, MentalStateExamCommandService>();
builder.Services.AddScoped<IMentalStateExamRepository, MentalStateExamRepository>();
builder.Services.AddScoped<ExternalExaminerService>();

//Configure Url to lowercase
builder.Services.AddRouting(options => options.LowercaseUrls = true);

//Add cors policy 
builder.Services.AddCors(configuration =>
{
    configuration.AddPolicy("AllowPolicy", policy =>
    {
        policy.AllowAnyHeader();
        policy.AllowAnyMethod();
        policy.AllowAnyOrigin();
    });
});

var app = builder.Build();

using (var scope = app.Services.CreateScope())
{
    var services = scope.ServiceProvider;
    var context = services.GetRequiredService<AppDbContext>();
    context.Database.EnsureCreated();
}

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment() || app.Environment.IsProduction())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseMiddleware<ErrorHandlerMiddleware>();
app.UseCors("AllowPolicy");
app.UseAuthorization();
app.UseHttpsRedirection();

app.MapControllers();

app.Run();
