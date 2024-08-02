using Business.Interface.Security;
using Entity.Dtos;
using Entity.Dtos.Security;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace Web.Controllers.Implements
{
    [Authorize]
    [Route("api/View")]
    [ApiController]
    public class ViewController : Controller
    {
        private readonly IViewBusiness _ViewBusiness;

        public ViewController(IViewBusiness ViewBusiness)
        {
            _ViewBusiness = ViewBusiness;
        }

        [HttpGet]
        public async Task<ActionResult<IEnumerable<ViewDto>>> GetAll()
        {
            var result = await _ViewBusiness.GetAll();
            return Ok(result);
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<ViewDto>> GetById(int id)
        {
            var result = await _ViewBusiness.GetById(id);
            if (result == null)
            {
                return NoContent();
            }

            return Ok(result);
        }

        [HttpGet("SELECT")]
        public async Task<ActionResult<IEnumerable<DataSelectDto>>> GetAllSelect()
        {
            var result = await _ViewBusiness.GetAllSelect();
            return Ok(result);
        }

        [HttpPost]
        public async Task<ActionResult<ViewDto>> Save([FromBody] ViewDto entity)
        {
            if (entity == null)
            {
                return BadRequest("Entity is null");
            }

            var result = await _ViewBusiness.Save(entity);
            return CreatedAtAction(nameof(GetById), new { id = entity.id }, result);
        }

        [HttpPut("{id}")]
        public async Task<IActionResult> Update(int id, [FromBody] ViewDto entity)
        {
            if (entity == null || id != entity.id)
            {
                return BadRequest();
            }

            await _ViewBusiness.Update(id, entity);
            return NoContent();
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> Delete(int id)
        {
            await _ViewBusiness.Delete(id);
            return NoContent();
        }
    }
}
