using DependencyInyection.Domain;
using Microsoft.AspNetCore.Hosting;
using Newtonsoft.Json;

namespace DependencyInyection.Repository
{
    public class FileCountryRepository : ICountryRepository
    {
        //Podria inyectar una dependencia si es necesario por ejemplo para mi aplicacion
        //Por ejemplo IwebHostEnvironment 
        private readonly IWebHostEnvironment _webHostEnvironment;
        public FileCountryRepository(IWebHostEnvironment webHostEnvironment) 
        {
            _webHostEnvironment = webHostEnvironment;
        }

        public Task<Country> CreateAsync(Country country)
        {
            throw new NotImplementedException();
        }

        public List<Country> GetCountries()
        {
            var basePath = _webHostEnvironment.ContentRootPath;

            var filePath = Path.Combine(basePath, "countries.json");

            var countriesAsString= File.ReadAllText(filePath);

            var countries = JsonConvert.DeserializeObject<List<Country>>(countriesAsString);

            return countries;
        }

        public async Task<List<Country>> GetCountriesAsync()
        {
            var basePath = _webHostEnvironment.ContentRootPath;

            var filePath = Path.Combine(basePath, "countries.json");

            var countriesAsString = await File.ReadAllTextAsync(filePath);

            var countries = JsonConvert.DeserializeObject<List<Country>>(countriesAsString);

            return countries;
        }
    }
}
