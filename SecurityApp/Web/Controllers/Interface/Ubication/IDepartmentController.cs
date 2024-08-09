using Entity.Dtos;
using Entity.Dtos.Ubication;
using Microsoft.AspNetCore.Mvc;

namespace Web.Controllers.Interface.Ubication
{
    public interface IDepartmentController
    {
        Task<ActionResult<IEnumerable<DepartmentDto>>> GetAll();

        Task<ActionResult<IEnumerable<DataSelectDto>>> GetAllSelect();

        Task<ActionResult<DepartmentDto>> GetById(int id);

        Task<ActionResult<DepartmentDto>> Save([FromBody] DepartmentDto entity);

        Task<IActionResult> Update(int id, [FromBody] DepartmentDto entity);

        Task<IActionResult> Delete(int id);
    }
}
