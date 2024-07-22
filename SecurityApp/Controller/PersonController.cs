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
    [Route("api/person")]
    [ApiController]
    public class PersonController
    {
        private readonly IPersonBusiness business;

        public PersonController(IPersonBusiness business)
        {
            this.business = business;
        }
        [HttpGet("datatable")]

        public async Task<ActionResult<ApiResponse<IEnumerable<DataSelectDto>>>> GetAllSelect()
        {

        }
        [HttpGet("{id}")]

        public async Task<ActionResult<ApiResponse<PersonDto>>> Get(int id)
        {

        }
        [HttpPost]

        public async Task<ActionResult> Post([FromBody] PersonDto person)
        {

        }
        [HttpPut("{id}")]

        public async Task<ActionResult> Put(int id, [FromBody] PersonDto person)
        {

        }
        [HttpDelete("{id}")]

        public async Task<ActionResult> Delete(int id)
        {

        }
    }
}
