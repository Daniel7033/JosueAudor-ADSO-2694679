using Data.Interface;
using Business.Interface.Security;
using Entity.Dtos;
using Entity.Dtos.Security;
using Entity.Model.Security;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Business.Implements.Security
{
    public class ModuloBusiness : IModuloBusiness
    {
        private readonly IModuloData data;

        public ModuloBusiness(IModuloData data)
        {
            this.data = data;
        }

        public async Task Delete(int id)
        {
            await this.data.Delete(id);
        }

        public async Task<IEnumerable<ModuloDto>> GetAll()
        {
            return await this.data.GetAll();
        }

        public async Task<IEnumerable<DataSelectDto>> GetAllSelect()
        {
            return await this.data.GetAllSelect();
        }

        public async Task<ModuloDto> GetById(int id)
        {
            Modulo modulo = await this.data.GetById(id);
            ModuloDto dto = new ModuloDto();

            dto.id = modulo.id;
            dto.Name = modulo.name;
            dto.Description = modulo.description;
            dto.Estado = modulo.estado;

            return dto;
        }

        public async Task<Modulo> Save(ModuloDto entity)
        {
            Modulo modulo = new Modulo();
            modulo = this.mapearDatos(modulo, entity);

            return await this.data.Save(modulo);
        }

        public async Task Update(int id, ModuloDto entity)
        {
            Modulo modulo = await this.data.GetById(id);
            if(modulo == null)
            {
                throw new Exception("Datos no encontrado");
            }
            modulo = this.mapearDatos(modulo, entity);

            await this.data.Update(modulo);
        }

        private Modulo mapearDatos(Modulo modulo, ModuloDto entity)
        {
            modulo.id = entity.id;
            modulo.name = entity.Name;
            modulo.description = entity.Description;
            modulo.estado = entity.Estado;

            return modulo;
        }
    }
}
