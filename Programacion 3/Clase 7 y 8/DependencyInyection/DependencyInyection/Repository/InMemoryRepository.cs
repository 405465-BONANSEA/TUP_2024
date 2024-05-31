using DependencyInyection.Domain;

namespace DependencyInyection.Repository
{
    public class InMemoryRepository: ICountryRepository
    {
        private static List<Country> _countries = new List<Country>()
        {

                new Country { Id = "1", Name = "Argentina" },
                new Country { Id = "2", Name = "France" },
                new Country { Id = "3", Name = "Brasil" },
                new Country { Id = "4", Name = "Alemania" },
                new Country { Id = "5", Name = "Portugal" }

    };
        public List<Country> GetCountries()
        {
            return _countries;

        }
    }
}
