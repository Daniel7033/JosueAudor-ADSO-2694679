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
    public interface IPersonBusiness
    {
        Task Delete(int id);

        Task<IEnumerable<PersonDto>> GetAll();

        Task<IEnumerable<DataSelectDto>> GetAllSelect();

        Task<PersonDto> GetById(int id);

        Task<Person> Save(PersonDto entity);

        Task Update(int id, PersonDto entity);
    }
}
