using Business.Implements.Security;
using Business.Implements.Ubication;
using Business.Interface.Security;
using Business.Interface.Ubication;
using Data.Implements.Security;
using Data.Implements.Ubication;
using Data.Interface.Security;
using Data.Interface.Ubication;
using Entity.Context;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);


// Add services to the container.

builder.Services.AddControllers();
builder.Services.AddDbContext<ApplicationDbContext>(options =>
    options.UseSqlServer(builder.Configuration.GetConnectionString("DbfaultConnection")));

//Configuracion Cords
builder.Services.AddCors(options =>
{
    options.AddPolicy("AllowSpecificOrigin",
        builder =>
        {
            builder.WithOrigins("http://localhost:4200")
                   .AllowAnyHeader()
                   .AllowAnyMethod();
        });
});

//Security

//Person
// Registra IPersonaData y su implementación
builder.Services.AddScoped<IPersonData, PersonData>();
// Registra IPersonasBusiness y su implementación
builder.Services.AddScoped<IPersonBusiness, PersonBusiness>();

//User
// Registra IUserData y su implementación
builder.Services.AddScoped<IUserData, UserData>();
// Registra IUserBusiness y su implementación
builder.Services.AddScoped<IUserBusiness, UserBusiness>();

//Modulo
// Registra IModuloData y su implementación
builder.Services.AddScoped<IModuloData, ModuloData>();
// Registra IModuloBusiness y su implementación
builder.Services.AddScoped<IModuloBusiness, ModuloBusiness>();

//Role
// Registra IRoleData y su implementación
builder.Services.AddScoped<IRoleData, RoleData>();
// Registra IRoleBusiness y su implementación
builder.Services.AddScoped<IRoleBusiness, RoleBusiness>();

//View
// Registra IViewData y su implementación
builder.Services.AddScoped<IViewData, ViewData>();
// Registra IViewBusiness y su implementación
builder.Services.AddScoped<IViewBusiness, ViewBusiness>();
// ------------------------------------------------------------------------------------

//Ubication

//Country
builder.Services.AddScoped<ICountryData, CountryData>();
builder.Services.AddScoped<ICountryBusiness, CountryBusiness>();

//Department
builder.Services.AddScoped<IDepartmentData, DepartmentData>();
builder.Services.AddScoped<IDepartmentBusiness, DepartmentBusiness>();

//City
builder.Services.AddScoped<ICityData, CityData>();
builder.Services.AddScoped<ICityBusiness, CityBusiness>();
//-----------------------------------------------------------------------------------

// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

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
