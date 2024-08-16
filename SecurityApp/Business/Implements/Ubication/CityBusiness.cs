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
    public class CityBusiness : ICityBusiness
    {
        private readonly ICityData data;

        public CityBusiness(ICityData data)
        {
            this.data = data;
        }

        public async Task Delete(int id)
        {
            await this.data.Delete(id);
        }

        public async Task<IEnumerable<CityDto>> GetAll()
        {
            return await this.data.GetAll();
        }

        public async Task<IEnumerable<DataSelectDto>> GetAllSelect()
        {
            return await this.data.GetAllSelect();
        }

        public async Task<CityDto> GetById(int id)
        {
            City city = await this.data.GetById(id);
            CityDto dto = new CityDto();

            dto.id = city.id;
            dto.Code = city.code;
            dto.Name = city.name;
            dto.Department = city.lstDepartment;
            dto.Estado = city.estado;

            return dto;
        }

        public async Task<City> Save(CityDto entity)
        {
            City city = new City();
            city = this.mapearDatos(city, entity);

            return await this.data.Save(city);
        }

        public async Task Update(int id, CityDto entity)
        {
            City city = await this.data.GetById(id);
            if (city == null)
            {
                throw new Exception("DATOS NO ENCONTRADOS");
            }
            city = this.mapearDatos(city, entity);

            await this.data.Update(city);
        }

        private City mapearDatos(City city, CityDto entity)
        {
            if (city.id == 0)
            {
                city.id = entity.id;
            }
            city.code = entity.Code;
            city.name = entity.Name;
            city.lstDepartment = entity.Department;
            city.estado = entity.Estado;

            return city;
        }
    }
}
