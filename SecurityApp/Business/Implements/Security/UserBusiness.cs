using Entity.Model.Security;
using Entity.Dtos.Security;
using Entity.Dtos;
using Data.Interface;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Business.Implements.Security
{
    public class UserBusiness : IUserBusiness
    {
        private readonly IUserData data;

        public UserBusiness(IUserData data)
        {
            this.data = data;
        }

        public async Task Delete(int id)
        {
            await this.data.Delete(id);
        }

        public async Task<IEnumerable<DataSelectDto>> GetAllSelect()
        {
            return await this.data.GetAllSelect();
        }

        public async Task<UserDto> GetById(int id)
        {
            User user = await this.data.GetById(id);
            UserDto dto = new UserDto();

            dto.id = user.id;
            dto.Username = user.username;
            dto.Password = user.password;
            dto.PersonId = user.personId;
            dto.Estado = user.estado;

            return dto;
        }

        public async Task<User> Save(UserDto entity)
        {
            User user = new User();
            user = this.mapearDatos(user, entity);

            return await this.data.Save(user);
        }

        public async Task Update(int id, UserDto entity)
        {
            User user = await this.data.GetById(id);
            if(user == null)
            {
                throw new Exception("Dato no encontrado");
            }
            user = this.mapearDatos(user, entity);

            await this.data.Update(user);
        }

        private User mapearDatos(User user, UserDto entity)
        {
            user.id = entity.id;
            user.username = entity.Username;
            user.password = entity.Password;
            user.personId = entity.PersonId;
            user.estado = entity.Estado;

            return user;
        }
    }
}
