using Entity.Dtos;
using Entity.Dtos.Security;
using Entity.Model.Security;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Business.Interface.Security
{
    public interface IUserBusiness
    {
        Task Delete(int id);

        Task<IEnumerable<UserDto>> GetAll();

        Task<IEnumerable<DataSelectDto>> GetAllSelect();

        Task<UserDto> GetById(int id);

        Task<User> Save(UserDto entity);

        Task Update(int id, UserDto entity);

        Task<LoginDto> Login(string username, string password);
    }
}
