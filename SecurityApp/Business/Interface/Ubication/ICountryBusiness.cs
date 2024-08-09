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
    public interface ICountryBusiness
    {
        Task Delete(int id);

        Task<IEnumerable<CountryDto>> GetAll();

        Task<IEnumerable<DataSelectDto>> GetAllSelect();

        Task<CountryDto> GetById(int id);

        Task<Country> Save(CountryDto entity);

        Task Update(int id, CountryDto entity);
    }
}
