using DependencyInyection.Domain;
using Microsoft.EntityFrameworkCore;

namespace DependencyInyection.Context
{
    public class CountryDbContext:DbContext
    {
        public CountryDbContext(DbContextOptions dbContextOptions): base(dbContextOptions)
        {
            
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            modelBuilder.Entity<Country>().HasData(
                new Country { Id = "1", Name = "Argentina" },
                new Country { Id = "2", Name = "France" },
                new Country { Id = "3", Name = "Brasil" },
                new Country { Id = "4", Name = "Alemania" },
                new Country { Id = "5", Name = "Portugal" }
                                                                                       );
        }
        public DbSet<Country> Countries { get; set; }
        

    }
}
