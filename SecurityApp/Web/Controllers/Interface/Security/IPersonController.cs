using Entity.Dtos;
using Entity.Dtos.Security;
using Microsoft.AspNetCore.Mvc;

namespace Web.Controllers.Interface.Security
{
    public interface IPersonController
    {
        Task<ActionResult<IEnumerable<PersonDto>>> GetAll();

        Task<ActionResult<PersonDto>> GetById(int id);

        Task<ActionResult<IEnumerable<DataSelectDto>>> GetAllSelect();

        Task<ActionResult<PersonDto>> Save([FromBody] PersonDto entity);

        Task<IActionResult> Update(int id, [FromBody] PersonDto entity);

        Task<IActionResult> Delete(int id);
    }
}
