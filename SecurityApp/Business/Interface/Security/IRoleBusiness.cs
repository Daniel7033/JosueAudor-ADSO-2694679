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
    public interface IRoleBusiness
    {
        Task Delete(int id);

        Task<IEnumerable<DataSelectDto>> GetAllSelect();

        Task<RoleDto> GetById(int id);

        Task<Role> Save(RoleDto entity);

        Task Update(int id, RoleDto entity);
    }
}
