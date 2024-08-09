using Entity.Dtos;
using Entity.Dtos.Ubication;
using Entity.Model.Ubication;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Interface.Ubication
{
    public interface IDepartmentData
    {
        Task Delete(int id);

        Task<IEnumerable<DepartmentDto>> GetAll();

        Task<IEnumerable<DataSelectDto>> GetAllSelect();

        Task<Department> GetById(int id);

        Task<Department> Save(Department entity);

        Task Update(Department entity);
    }
}
