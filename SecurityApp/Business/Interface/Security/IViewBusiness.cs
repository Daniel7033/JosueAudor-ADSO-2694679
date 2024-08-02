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
    public interface IViewBusiness
    {
        Task Delete(int id);

        Task<IEnumerable<ViewDto>> GetAll();

        Task<IEnumerable<DataSelectDto>> GetAllSelect();

        Task<ViewDto> GetById(int id);

        Task<View> Save(ViewDto entity);

        Task Update(int id, ViewDto entity);
    }
}
