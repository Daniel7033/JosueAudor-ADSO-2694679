using Entity.Dtos;
using Entity.Dtos.Security;
using Entity.Model.Security;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Interface
{
    public interface IPersonData
    {
        Task Delete(int id);

        Task<IEnumerable<PersonDto>> GetAll();

        Task<IEnumerable<DataSelectDto>> GetAllSelect();

        Task<Person> GetById(int id);

        /* INHABILITADO
         * Task<PageListDto<PersonDto>> GetDataTable(QueryFilterDto filter);*/

        Task<Person> Save(Person entity);

        Task Update(Person entity);
    }
}
