using Entity.Dtos;
using Entity.Model.Security;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Interface
{
    public interface IModuloData
    {
        Task Delete(int id);

        Task<IEnumerable<DataSelectDto>> GetAllSelect();

        Task<Modulo> GetById(int id);

        /* INHABILITADO
         * Task<PageListDto<ModuloDto>> GetDataTable(QueryFilterDto filter);*/

        Task<Modulo> Save(Modulo entity);

        Task Update(Modulo entity);
    }
}
