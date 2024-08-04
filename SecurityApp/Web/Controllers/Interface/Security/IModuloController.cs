using Entity.Dtos;
using Entity.Dtos.Security;
using Microsoft.AspNetCore.Mvc;

namespace Web.Controllers.Interface.Security
{
    public interface IModuloController
    {
        Task<ActionResult<IEnumerable<ModuloDto>>> GetAll();

        Task<ActionResult<ModuloDto>> GetById(int id);

        Task<ActionResult<IEnumerable<DataSelectDto>>> GetAllSelect();

        Task<ActionResult<ModuloDto>> Save([FromBody] ModuloDto entity);

        Task<IActionResult> Update(int id, [FromBody] ModuloDto entity);

        Task<IActionResult> Delete(int id);
    }
}
