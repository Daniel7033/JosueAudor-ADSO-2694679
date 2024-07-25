using Business.Interface.Security;
using Entity.Dtos;
using Entity.Model.Security;
using Entity.Dtos.Security;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controller.Security
{
    [Authorize]
    [Route("api/[view]")]
    [ApiController]
    public class ViewController
    {
        private readonly IViewBusiness business;

        public ViewController(IViewBusiness business)
        {
            this.business = business;
        }
        [HttpGet("datatable")]

        public async Task<ActionResult<ApiResponse<IEnumerable<DataSelectDto>>>> GetAllSelect()
        {

        }
        [HttpGet("{id}")]

        public async Task<ActionResult<ApiResponse<ViewDto>>> Get(int id)
        {

        }
        [HttpPost]

        public async Task<ActionResult> Post([FromBody] ViewDto viewDto)
        {
            try
            {
                View view = await business.Save(viewDto);
                var response = new ApiResponse<ViewDto>(null, true, "Registro Guardado Éxitosamente.", null);

                return new CreatedAtRouteResult(new { id = view.id }, response);
            }
            catch (Exception ex)
            {
                var response = new ApiResponse<IEnumerable<View>>(null, false, ex.Message.ToString(), null);

                return StatusCode(StatusCodes.Status500InternalServerError, response);
            }
        }
        [HttpPut("{id}")]

        public async Task<ActionResult> Put(int id, [FromBody] ViewDto view)
        {

        }
        [HttpDelete("{id}")]

        public async Task<ActionResult> Delete(int id)
        {

        }
    }
}
