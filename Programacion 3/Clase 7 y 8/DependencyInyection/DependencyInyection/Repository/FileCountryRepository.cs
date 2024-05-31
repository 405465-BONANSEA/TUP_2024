using DependencyInyection.Domain;
using Newtonsoft.Json;

namespace DependencyInyection.Repository
{
    public class FileCountryRepository : ICountryRepository
    {
        //Podria inyectar una dependencia si es necesario por ejemplo para mi aplicacion
        //Por ejemplo IwebHostEnvironment 
        private readonly IWebHostEnvironment _webHostEnviroment;
        public FileCountryRepository(IWebHostEnvironment webHostEnvironment) 
        {
            _webHostEnviroment = webHostEnvironment;
        }

        public List<Country> GetCountries()
        {
            var basePath = _webHostEnviroment.ContentRootPath;

            var filePath = Path.Combine(basePath, "countries.json");

            var countriesAsString= File.ReadAllText(filePath);

            var countries = JsonConvert.DeserializeObject<List<Country>>(countriesAsString);

            return countries;
        }
    }
}
