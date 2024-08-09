using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entity.Dtos.Security
{
    public class LoginDto
    {
        public string Username { get; set; }

        public string Modulo { get; set; }
        public string Formulario { get; set; }
    }
}
