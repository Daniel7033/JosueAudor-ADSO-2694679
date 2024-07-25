using Business.Interface.Security;
using Entity.Dtos;
using Entity.Dtos.Security;
using Entity.Model.Security;
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
    [Route("api/[role]")]
    [ApiController]
    public class RoleController
    {
        private readonly IRoleBusiness business;

        public RoleController(IRoleBusiness business)
        {
            this.business = business;
        }
        [HttpGet("datatable")]

        public async Task<ActionResult<ApiResponse<IEnumerable<DataSelectDto>>>> GetAllSelect()
        {

        }
        [HttpGet("{id}")]

        public async Task<ActionResult<ApiResponse<RoleDto>>> Get(int id)
        {

        }
        [HttpPost]

        public async Task<ActionResult> Post([FromBody] RoleDto roleDto)
        {
            try
            {
                Role role = await business.Save(roleDto);
                var response = new ApiResponse<RoleDto>(null, true, "Registro Guarado Éxitosamente.", null);

                return new CreatedAtRouteResult(new { id = role.id }, response);
            }
            catch (Exception ex)
            {
                var response = new ApiResponse<IEnumerable<Role>>(null, false, ex.Message.ToString(), null);
                return StatusCode(StatusCodes.Status500InternalServerError, response);
            }
        }
        [HttpPut("{id}")]

        public async Task<ActionResult> Put(int id, [FromBody] RoleDto role)
        {

        }
        [HttpDelete("{id}")]

        public async Task<ActionResult> Delete(int id)
        {

        }
    }
}
