using Entity.Dtos;
using Entity.Dtos.Security;
using Entity.Model.Security;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Interface.Security
{
    public interface IUserData
    {
        Task Delete(int id);

        Task<IEnumerable<UserDto>> GetAll();

        Task<IEnumerable<DataSelectDto>> GetAllSelect();

        Task<User> GetById(int id);

        /* INHABILITADO
         * Task<PageListDto<UserDto>> GetDataTable(QueryFilterDto filter);*/

        Task<User> Save(User entity);

        Task Update(User entity);

        Task<LoginDto> Login(string username, string password);
    }
}
