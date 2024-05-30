﻿using DependencyInyection.Repository;
using Microsoft.AspNetCore.Mvc;

namespace DependencyInyection.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CountryController : ControllerBase
    {
        //IYECCION DE DEPENDENCIAS de aca
        private readonly ICountryRepository _countryRepository;
        public CountryController(ICountryRepository countryRepository)
        {
          _countryRepository = countryRepository;
        }
        //hasta aca

        [HttpGet]
        public IActionResult Get()
        {
            var countryRepository = new InMemoryRepository();

            var countries = countryRepository.GetCountries();
            return Ok(countries);
        }

        [HttpGet("v2")]
        public IActionResult GetV2()
        {
            

            var countries = _countryRepository.GetCountries();
            return Ok(countries);
        }
    }
}
