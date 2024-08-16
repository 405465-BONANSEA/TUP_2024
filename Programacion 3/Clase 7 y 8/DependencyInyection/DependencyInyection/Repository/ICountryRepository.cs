using DependencyInyection.Domain;

namespace DependencyInyection.Repository
{
    public interface ICountryRepository
    {
        List<Country> GetCountries();
        Task<List<Country>> GetCountriesAsync();

        Task<Country> CreateAsync(Country country);


    }
}