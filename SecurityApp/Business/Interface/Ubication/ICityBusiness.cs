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
    public interface ICityBusiness
    {
        Task Delete(int id);

        Task<IEnumerable<CityDto>> GetAll();

        Task<IEnumerable<DataSelectDto>> GetAllSelect();

        Task<CityDto> GetById(int id);

        Task<City> Save(CityDto entity);

        Task Update(int id, CityDto entity);
    }
}
