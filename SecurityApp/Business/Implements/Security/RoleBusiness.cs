using Business.Interface.Security;
using Data.Interface;
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
    public class RoleBusiness : IRoleBusiness
    {
        private readonly IRoleData data;

        public RoleBusiness(IRoleData data)
        {
            this.data = data;
        }

        public async Task Delete(int id)
        {
            await this.data.Delete(id);
        }

        public async Task<IEnumerable<RoleDto>> GetAll()
        {
            return await this.data.GetAll();
        }

        public async Task<IEnumerable<DataSelectDto>> GetAllSelect()
        {
            return await this.data.GetAllSelect();
        }

        public async Task<RoleDto> GetById(int id)
        {
            Role role = await this.data.GetById(id);
            RoleDto dto = new RoleDto();

            dto.id = role.id;
            dto.Name = role.name;
            dto.Description = role.description;
            dto.Estado = role.estado;

            return dto;
        }

        public async Task<Role> Save(RoleDto entity)
        {
            Role role = new Role();
            role = this.mapearDatos(role, entity);

            return await this.data.Save(role);
        }

        public async Task Update(int id, RoleDto entity)
        {
            Role role = await this.data.GetById(id);
            if(role == null)
            {
                throw new Exception("Dato no encontrado.");
            }
            role = this.mapearDatos(role, entity);

            await this.data.Update(role);
        }

        private Role mapearDatos(Role role, RoleDto entity)
        {
            if (role.id == 0)
            {
                role.id = entity.id;
            }
            role.name = entity.Name;
            role.description = entity.Description;
            role.estado = entity.Estado;

            return role;
        }
    }
}
