using DependencyInyection.Domain;

namespace DependencyInyection.Repository
{
    public interface ICountryRepository
    {
        List<Country> GetCountries();


    }
}