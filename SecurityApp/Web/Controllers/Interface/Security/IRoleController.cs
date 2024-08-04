using Entity.Dtos;
using Entity.Dtos.Security;
using Microsoft.AspNetCore.Mvc;

namespace Web.Controllers.Interface.Security
{
    public interface IRoleController
    {
        Task<ActionResult<IEnumerable<RoleDto>>> GetAll();

        Task<ActionResult<RoleDto>> GetById(int id);

        Task<ActionResult<IEnumerable<DataSelectDto>>> GetAllSelect();

        Task<ActionResult<RoleDto>> Save([FromBody] RoleDto entity);

        Task<IActionResult> Update(int id, [FromBody] RoleDto entity);

        Task<IActionResult> Delete(int id);
    }
}
