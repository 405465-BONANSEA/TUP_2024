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
        public List<Country> GetCountries()
        {
            return _context.Countries.ToList();
        }
    }
}
