using Business.Interface.Security;
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
    }
}
