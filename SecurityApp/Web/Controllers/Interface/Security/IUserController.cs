using Entity.Dtos;
using Entity.Dtos.Security;
using Microsoft.AspNetCore.Mvc;

namespace Web.Controllers.Interface.Security
{
    public interface IUserController
    {
        Task<ActionResult<IEnumerable<UserDto>>> GetAll();

        Task<ActionResult<UserDto>> GetById(int id);

        Task<ActionResult<IEnumerable<DataSelectDto>>> GetAllSelect();

        Task<ActionResult<UserDto>> Save([FromBody] UserDto entity);

        Task<IActionResult> Update(int id, [FromBody] UserDto entity);

        Task<IActionResult> Delete(int id);
    }
}
