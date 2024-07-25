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
using Entity.Model.Security;

namespace Controller.Security
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

        public async Task<ActionResult> Post([FromBody] UserDto userDto)
        {
            try
            {
                User user = await business.Save(userDto);
                var response = new ApiResponse<UserDto>(null, true, "Registro Guardado Éxitosamentee.", null);

                return new CreatedAtRouteResult(new { id = user.id }, response);
            }
            catch (Exception ex)
            {
                var response = new ApiResponse<IEnumerable<User>>(null, false, ex.Message.ToString(), null);

                return new StatusCode(StatusCodes.Status500InternalServerError, response);
            }
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
