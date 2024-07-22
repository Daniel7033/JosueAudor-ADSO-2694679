using Business.Interface.Security;
using Entity.Dtos;
using Entity.Dtos.Security;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controller
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

        public async Task<ActionResult> Post([FromBody] RoleDto role)
        {

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
