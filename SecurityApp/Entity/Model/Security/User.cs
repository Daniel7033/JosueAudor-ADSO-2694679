using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entity.Model.Security
{
    public class User
    {
        public int id { get; set; }

        public string username { get; set; }

        public string password { get; set; }

        public DateTime createdAt { get; set; }

        public DateTime updatedAt { get; set; }

        public DateTime deletedAt { get; set; }

        public Boolean estado { get; set; }

        public int lstUser { get; set; }

        public Person personId { get; set; }
    }
}
