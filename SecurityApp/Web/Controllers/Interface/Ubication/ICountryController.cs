using Entity.Dtos;
using Entity.Dtos.Ubication;
using Microsoft.AspNetCore.Mvc;

namespace Web.Controllers.Interface.Ubication
{
    public interface ICountryController
    {
        Task<ActionResult<IEnumerable<CountryDto>>> GetAll();

        Task<ActionResult<IEnumerable<DataSelectDto>>> GetAllSelect();

        Task<ActionResult<CountryDto>> GetById(int id);

        Task<ActionResult<CountryDto>> Save([FromBody] CountryDto entity);

        Task<IActionResult> Update(int id, [FromBody] CountryDto entity);

        Task<IActionResult> Delete(int id);
    }
}
