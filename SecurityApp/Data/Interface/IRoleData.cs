using Entity.Dtos;
using Entity.Model.Security;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Interface
{
    public interface IRoleData
    {
        Task Delete(int id);

        Task<IEnumerable<DataSelectDto>> GetAllSelect();

        Task<Role> GetById(int id);

        /* INHABILITADO
         * Task<PageListDto<RoleDto>> GetDataTable(QueryFilterDto filter);*/

        Task<Role> Save(Role entity);

        Task Update(Role entity);

    }
}
