using Business.Interface.Ubication;
using Data.Interface.Ubication;
using Entity.Dtos;
using Entity.Dtos.Ubication;
using Entity.Model.Ubication;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Business.Implements.Ubication
{
    public class CountryBusiness : ICountryBusiness
    {
        private readonly ICountryData data;

        public CountryBusiness(ICountryData data)
        {
            this.data = data;
        }

        public async Task Delete(int id)
        {
            await this.data.Delete(id);
        }

        public async Task<IEnumerable<CountryDto>> GetAll()
        {
            return await this.data.GetAll();
        }

        public async Task<IEnumerable<DataSelectDto>> GetAllSelect()
        {
            return await this.data.GetAllSelect();
        }

        public async Task<CountryDto> GetById(int id)
        {
            Country country = await this.data.GetById(id);
            CountryDto dto = new CountryDto();

            dto.id = country.id;
            dto.Code = country.code;
            dto.Name = country.name;
            dto.Estado = country.estado;

            return dto;
        }

        public async Task<Country> Save(CountryDto entity)
        {
            Country country = new Country();
            country = this.mapearDatos(country, entity);

            return await this.data.Save(country);
        }

        public async Task Update(int id, CountryDto entity)
        {
            Country country = await this.data.GetById(id);
            if (country == null)
            {
                throw new Exception("Dato no encontrado");
            }
            country = this.mapearDatos(country, entity);
            await this.data.Update(country);
        }

        private Country mapearDatos(Country country, CountryDto entity)
        {
            if (country.id == 0)
            {
                country.id = entity.id;
            }
            country.code = entity.Code;
            country.name = entity.Name;
            country.estado = entity.Estado;

            return country;
        }
    }
}
