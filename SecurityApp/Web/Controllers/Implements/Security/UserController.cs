using Business.Interface.Security;
using Entity.Dtos;
using Entity.Dtos.Security;
using Entity.Model.Security;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Web.Controllers.Implements.Security
{
    [Route("api/User")]
    [ApiController]
    public class UserController : Controller
    {
        private readonly IUserBusiness _UserBusiness;

        public UserController(IUserBusiness UserBusiness)
        {
            _UserBusiness = UserBusiness;
        }

        [HttpGet]
        public async Task<ActionResult<IEnumerable<UserDto>>> GetAll()
        {
            var result = await _UserBusiness.GetAll();
            return Ok(result);
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<UserDto>> GetById(int id)
        {
            var result = await _UserBusiness.GetById(id);

            if (result == null)
            {
                return NotFound();
            }

            return Ok(result);
        }

        [HttpGet("SELECT")]
        public async Task<ActionResult<IEnumerable<DataSelectDto>>> GetAllSelect()
        {
            var result = await _UserBusiness.GetAllSelect();
            return Ok(result);
        }

        [HttpGet("Login")]
        public async Task<ActionResult<LoginDto>> Login(string username, string password)
        {
            var result = await _UserBusiness.Login(username, password);
            if (result == null)
            {
                return NotFound();
            }
            return Ok(result);
        }

        [HttpPost]
        public async Task<ActionResult<UserDto>> Save([FromBody] UserDto entity)
        {
            if (entity == null)
            {
                return BadRequest("Entity is null");
            }

            var result = await _UserBusiness.Save(entity);
            return CreatedAtAction(nameof(GetById), new { entity.id }, result);
        }

        [HttpPut("{id}")]
        public async Task<IActionResult> Update(int id, [FromBody] UserDto entity)
        {
            if (entity == null || id != entity.id)
            {
                return BadRequest();
            }

            await _UserBusiness.Update(id, entity);
            return NoContent();
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> Delete(int id)
        {
            await _UserBusiness.Delete(id);
            return NoContent();
        }
    }
}
