using Entity.Dtos;
using Entity.Dtos.Security;
using Microsoft.AspNetCore.Mvc;

namespace Web.Controllers.Interface.Security
{
    public interface IViewController
    {
        Task<ActionResult<IEnumerable<ViewDto>>> GetAll();

        Task<ActionResult<ViewDto>> GetById(int id);

        Task<ActionResult<IEnumerable<DataSelectDto>>> GetAllSelect();

        Task<ActionResult<ViewDto>> Save([FromBody] ViewDto entity);

        Task<IActionResult> Update(int id, [FromBody] ViewDto entity);

        Task<IActionResult> Delete(int id);
    }
}
