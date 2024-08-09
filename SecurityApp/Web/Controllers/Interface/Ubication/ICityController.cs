using Entity.Dtos;
using Entity.Dtos.Ubication;
using Microsoft.AspNetCore.Mvc;

namespace Web.Controllers.Interface.Ubication
{
    public interface ICityController
    {
        Task<ActionResult<IEnumerable<CityDto>>> GetAll();

        Task<ActionResult<IEnumerable<DataSelectDto>>> GetAllSelect();

        Task<ActionResult<CityDto>> GetById(int id);

        Task<ActionResult<CityDto>> Save([FromBody] CityDto entity);

        Task<IActionResult> Update(int id, [FromBody] CityDto entity);

        Task<IActionResult> Delete(int id);
    }
}
