using Business.Interface.Security;
using Entity.Dtos;
using Entity.Dtos.Security;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace Web.Controllers.Implements
{
    [Authorize]
    [Route("api/Role")]
    [ApiController]
    public class RoleController : Controller
    {
        private readonly IRoleBusiness _RoleBusiness;

        public RoleController(IRoleBusiness RoleBusiness)
        {
            _RoleBusiness = RoleBusiness;
        }

        [HttpGet]
        public async Task<ActionResult<IEnumerable<RoleDto>>> GetAll()
        {
            var result = await _RoleBusiness.GetAll();
            return Ok(result);
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<RoleDto>> GetById(int id)
        {
            var result = await _RoleBusiness.GetById(id);

            if(result == null)
            {
                return NotFound();
            }

            return Ok(result);
        }

        [HttpGet("SELECT")]
        public async Task<ActionResult<IEnumerable<DataSelectDto>>> GetAllSelect()
        {
            var result = await _RoleBusiness.GetAllSelect();
            return Ok(result);
        }

        [HttpPost]
        public async Task<ActionResult<RoleDto>> Save([FromBody] RoleDto entity)
        {
            if (entity == null)
            {
                return BadRequest("Entity is null");
            }

            var result = await _RoleBusiness.Save(entity);
            return CreatedAtAction(nameof(GetById), new { id = entity.id }, result);
        }

        [HttpPut("{id}")]
        public async Task<IActionResult> Update(int id, [FromBody] RoleDto entity)
        {
            if (entity == null || id != entity.id)
            {
                return BadRequest();
            }

            await _RoleBusiness.Update(id, entity);
            return NoContent();
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> Delete(int id)
        {
            await _RoleBusiness.Delete(id);
            return NoContent();
        }
    }
}
