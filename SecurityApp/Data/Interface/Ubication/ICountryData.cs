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
    public interface ICountryData
    {
        Task Delete(int id);

        Task<IEnumerable<CountryDto>> GetAll();

        Task<IEnumerable<DataSelectDto>> GetAllSelect();

        Task<Country> GetById(int id);

        Task<Country> Save(Country entity);

        Task Update(Country entity);
    }
}
