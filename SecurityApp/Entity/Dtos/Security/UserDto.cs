using Entity.Model.Security;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entity.Dtos.Security
{
    public class UserDto
    {
        public int id { get; set; }

        public string Username { get; set; }

        public string Password { get; set; }

        public Person PersonId { get; set; }

        public Boolean Estado { get; set; }
    }
}
