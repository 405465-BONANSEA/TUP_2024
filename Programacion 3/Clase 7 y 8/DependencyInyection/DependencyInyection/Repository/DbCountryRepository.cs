using DependencyInyection.Context;
using DependencyInyection.Domain;
using Microsoft.EntityFrameworkCore;

namespace DependencyInyection.Repository
{
    public class DbCountryRepository : ICountryRepository
    {
        private readonly CountryDbContext _context;
        public DbCountryRepository(CountryDbContext context)
        {
             _context = context; 
        }

        public async Task<Country> CreateAsync(Country country)
        {
            await _context.Countries.AddAsync(country);
            await _context.SaveChangesAsync();

            return country;
        }

        public List<Country> GetCountries()
        {
            return _context.Countries.AsEnumerable().OrderBy(c => int.Parse(c.Id)).ToList();
        }

        public async Task<List<Country>> GetCountriesAsync()
        {
            return (await _context.Countries.ToListAsync()).OrderBy(c => int.Parse(c.Id)).ToList();
        }


    }
}
