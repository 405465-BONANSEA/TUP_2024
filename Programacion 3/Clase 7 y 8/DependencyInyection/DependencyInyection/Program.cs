using DependencyInyection.Context;
using DependencyInyection.Repository;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

//INYECCION DE DEPENDENCIAS ES CUANDO YO PIDO UNA INTERFAZ Y ME RETORNA UNA IMPLEMENTACION DE UN OBJETO
//INYECCION DE CONTROL ES LA ESPECIFICACION DE CUANDO USO LA IMPLEMENTACION DE UNA CLASE 

//*SE AGREGA A LA INYECCION DE DEPENDENCIAS de ICountry a InMemoryRepository (SI QUERO POR MEMORIA)
//builder.Services.AddSingleton<ICountryRepository, InMemoryRepository>(); //instancia unica para toda la app
//builder.Services.AddScoped<ICountryRepository, InMemoryRepository>(); //instancia por ambito, en caso de un controller seria por request


//*SE AGREGA A LA INYECCION DE DEPENDENCIAS de ICountry a FileCountryRepository (SI QUERO POR ARCHIVO)
//builder.Services.AddTransient<ICountryRepository, FileCountryRepository>(); //una instancia cada vez que es requerida


//*SE AGREGA A LA INYECCION DE DEPENDENCIAS DE DBCOUNTRYREPOSITORY (SI QUERO POR BASE DE DATOS)
//AHORA CON ESTE EL v2 ME TRAE 6 ITEMS PORQUE AGREGUE UNO DESDE SQL SERVER
builder.Services.AddTransient<ICountryRepository, DbCountryRepository>(); //una instancia cada vez que es requerida

//*SE AGREGA A LA INYECCION DE DEPENDENCIAS DE APICOUNTRYREPOSITORY (SI QUERO POR API)
// HOY DIA 06/06/2024 NO FUNCIONA PORQUE EL API DE RESTCOUNTRIES NO ESTA FUNCIONANDO
//builder.Services.AddSingleton<ICountryRepository, ApiCountryRepository>(); //instancia unica para toda la app

//*INYECCION DEL CLIENTE HTTP
builder.Services.AddHttpClient("CountryApi", options =>
{
    options.BaseAddress = new Uri("https://restcountries.com/v3.1/");
});

//*INYECCION DEL CONTEXTO DEL DB
builder.Services.AddDbContext<CountryDbContext>((context) =>
{

    context.UseSqlServer(builder.Configuration.GetConnectionString("CountryDb"));
});

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}
// ESTO ES PARA QUE NO SE BLOQUEE EL CORS
app.UseCors(options =>
{
    options.AllowAnyOrigin();
    options.AllowAnyHeader();
});

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
