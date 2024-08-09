using Entity.Dtos;
using Entity.Dtos.Ubication;
using Entity.Model.Ubication;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Business.Interface.Ubication
{
    public interface IDepartmentBusiness
    {
        Task Delete(int id);

        Task<IEnumerable<DepartmentDto>> GetAll();

        Task<IEnumerable<DataSelectDto>> GetAllSelect();

        Task<DepartmentDto> GetById(int id);

        Task<Department> Save(DepartmentDto entity);

        Task Update(int id, DepartmentDto entity);
    }
}
