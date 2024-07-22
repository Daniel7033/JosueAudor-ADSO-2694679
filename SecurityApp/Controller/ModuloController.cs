using Business.Interface;
using Business.Interface.Security;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace Controller
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
    }
}