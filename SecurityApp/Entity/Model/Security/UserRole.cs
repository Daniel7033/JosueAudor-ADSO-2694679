using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entity.Model.Security
{
    public class UserRole
    {
        public int id { get; set; }

        public int lstUser { get; set; }

        public int lstRole { get; set; }

        public User userId { get; set; }

        public Role roleId { get; set; }
    }
}
