using Business.Interface;
using Business.Interface.Security;
using Entity.Dtos;
using Entity.Dtos.Security;
using Entity.Model.Security;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.ApiExplorer;

namespace Controller.Security
{
    [Authorize]
    [Route("api/module")]
    [ApiController]
    public class ModuloController
    {
        private readonly IModuloBusiness business;

        public ModuloController(IModuloBusiness business)
        {
            this.business = business;
        }
        [HttpGet("datatable")]

        public async Task<ActionResult<ApiResponse<IEnumerable<DataSelectDto>>>> GetAllSelect()
        {

        }
        [HttpGet("{id}")]

        public async Task<ActionResult<ApiResponse<ModuloDto>>> Get(int id)
        {

        }
        [HttpPost]

        public async Task<ActionResult> Post([FromBody] ModuloDto moduloDto)
        {
            try 
            {
                Modulo modulo = await business.Save(moduloDto);
                var response = new ApiResponse<ModuloDto>(null, true, "Registro Guardado Éxitosamente.", null);

                return new CreatedAtRouteResult(new { id = modulo.id }, response);
            }
            catch (Exception ex)
            {
                var response = new ApiResponse<IEnumerable<Modulo>>(null, false, ex.Message.ToString(), null);

                return StatusCode(StatusCodes.Status500InternalServerError, response);
            }
        }
        [HttpPut("{id}")]

        public async Task<ActionResult> Put(int id, [FromBody] ModuloDto moduloDto)
        {

        }
        [HttpDelete("{id}")]

        public async Task<ActionResult> Delete()
        {

        }
    }
}