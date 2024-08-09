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
    public class DepartmentBusiness : IDepartmentBusiness
    {
        private readonly IDepartmentData data;

        public DepartmentBusiness(IDepartmentData data)
        {
            this.data = data;
        }

        public async Task Delete(int id)
        {
            await this.data.Delete(id);
        }

        public async Task<IEnumerable<DepartmentDto>> GetAll()
        {
            return await this.data.GetAll();
        }

        public async Task<IEnumerable<DataSelectDto>> GetAllSelect()
        {
            return await this.data.GetAllSelect();
        }

        public async Task<DepartmentDto> GetById(int id)
        {
            Department depa = await this.data.GetById(id);
            DepartmentDto dto = new DepartmentDto();

            dto.id = depa.id;
            dto.Code = depa.code;
            dto.Name = depa.name;
            dto.Country = depa.countryId;
            dto.Estado = depa.estado;

            return dto;
        }

        public async Task<Department> Save(DepartmentDto entity)
        {
            Department depa = new Department();
            depa = this.mapearDatos(depa, entity);

            return await this.data.Save(depa);
        }

        public async Task Update(int id, DepartmentDto entity)
        {
            Department depa = await this.data.GetById(id);
            if (depa == null)
            {
                throw new Exception("Dato no encontrado");
            }
            depa = this.mapearDatos(depa, entity);

            await this.data.Update(depa);
        }

        private Department mapearDatos(Department depa, DepartmentDto entity)
        {
            if (depa.id == 0)
            {
                depa.id = entity.id;
            }
            depa.code = entity.Code;
            depa.name = entity.Name;
            depa.countryId = entity.Country;
            depa.estado = entity.Estado;

            return depa;
        }
    }
}
