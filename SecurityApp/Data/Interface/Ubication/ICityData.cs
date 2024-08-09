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
    public interface ICityData
    {
        Task Delete(int id);

        Task<IEnumerable<CityDto>> GetAll();

        Task<IEnumerable<DataSelectDto>> GetAllSelect();

        Task<City> GetById(int id);

        Task<City> Save(City entity);

        Task Update(City entity);
    }
}
