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
    public interface IModuloBusiness
    {
        Task Delete(int id);

        Task<IEnumerable<DataSelectDto>> GetAllSelect();

        Task<ModuloDto> GetById(int id);

        Task<Modulo> Save(ModuloDto entity);

        Task Update(int id, ModuloDto entity);
    }
}
