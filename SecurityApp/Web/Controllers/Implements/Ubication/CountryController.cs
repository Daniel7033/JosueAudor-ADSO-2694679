using Business.Interface.Ubication;
using Entity.Dtos.Ubication;
using Entity.Dtos;
using Microsoft.AspNetCore.Mvc;

namespace Web.Controllers.Implements.Ubication
{
    [Route("api/Country")]
    [ApiController]
    public class CountryController : Controller
    {
        private readonly ICountryBusiness _countryBusiness;

        public CountryController(ICountryBusiness countryBusiness)
        {
           _countryBusiness = countryBusiness;
        }

        [HttpGet]
        public async Task<ActionResult<IEnumerable<CountryDto>>> GetAll()
        {
            var result = await _countryBusiness.GetAll();
            return Ok(result);
        }

        [HttpGet("SELECT")]
        public async Task<ActionResult<IEnumerable<DataSelectDto>>> GetAllSelect()
        {
            var result = await _countryBusiness.GetAllSelect();
            return Ok(result);
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<CountryDto>> GetById(int id)
        {
            var result = _countryBusiness.GetById(id);
            if (result == null)
            {
                return NotFound();
            }
            return Ok(result);
        }

        [HttpPost]
        public async Task<ActionResult<CountryDto>> Save([FromBody] CountryDto entity)
        {
            if (entity == null)
            {

                return BadRequest("ENTITY IS NULL");
            }

            var result = await _countryBusiness.Save(entity);
            return CreatedAtAction(nameof(GetById), new { result.id }, result);
        }

        [HttpPut("{id}")]
        public async Task<IActionResult> Update(int id, [FromBody] CountryDto entity)
        {
            if (entity == null || id != entity.id)
            {
                return BadRequest();
            }

            await _countryBusiness.Update(id, entity);
            return NoContent();
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> Delete(int id)
        {
            await _countryBusiness.Delete(id);
            return NoContent();
        }
    }
}
