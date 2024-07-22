using Business.Interface.Security;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Http;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc.ApiExplorer;
using Entity.Dtos;
using Entity.Dtos.Security;

namespace Controller
{
    [Authorize]
    [Route("api/[user]")]
    [ApiController]
    public class UserController
    {
        private readonly IUserBusiness business;

        public UserController(IUserBusiness business)
        {
            this.business = business;   
        }
        [HttpGet("datatable")]

        public async Task<ActionResult<ApiResponse<IEnumerable<DataSelectDto>>>> GetAllSelect()
        {

        }
        [HttpGet("{id}")]

        public async Task<Action<ApiResponse<UserDto>>> Get(int id)
        {

        }
        [HttpPost]

        public async Task<ActionResult> Post([FromBody] UserDto user)
        {

        }
        [HttpPut("{id}")]

        public async Task<ActionResult> Put(int id, [FromBody] UserDto user)
        {

        }
        [HttpDelete("{id}")]

        public async Task<ActionResult> Delete(int id)
        {

        }
    }
}
