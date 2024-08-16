
using DependencyInyection.Domain;
using DependencyInyection.Dto;
using Newtonsoft.Json;

namespace DependencyInyection.Repository
{
    public class ApiCountryRepository: ICountryRepository
    {
        private readonly HttpClient _httpClient;

        public ApiCountryRepository(IHttpClientFactory httpClientFactory)
        {
            _httpClient = httpClientFactory.CreateClient("CountryApi");
        }

        public Task<Country> CreateAsync(Country country)
        {
            throw new NotImplementedException();
        }

        public List<Country> GetCountries()
        {
            throw new NotImplementedException();
        }

        public async Task<List<Country>> GetCountriesAsync()
        {
            try
            {
                var response = await _httpClient.GetFromJsonAsync<List<CountryApiDto>>("all");

                var countries = response.Select(c => new Country
                {
                    Id = c.ccn3,
                    Name = c.Name.official
                }).ToList();

                return countries.OrderBy(c => int.Parse(c.Id)).ToList();
            }
            catch (Exception ex)
            {
                return new List<Country>();
            }
        }

    }
}
