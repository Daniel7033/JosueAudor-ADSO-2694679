using Entity.Dtos;
using Entity.Model.Security;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Interface
{
    public interface IViewData
    {
        Task Delete(int id);

        Task<IEnumerable<DataSelectDto>> GetAll();

        Task<IEnumerable<DataSelectDto>> GetAllSelect();

        Task<View> GetById(int id);

        /* INHABILITADO
         * Task<PageListDto<ViewDto>> GetDataTable(QueryFilterDto filter);*/

        Task<View> Save(View entity);

        Task Update(View entity);
    }
}
