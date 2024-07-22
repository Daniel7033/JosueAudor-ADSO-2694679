using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entity.Model.Security
{
    public class RoleView
    {
        public int id { get; set; }

        public DateTime createdAt { get; set; }

        public DateTime updatedAt { get; set; }

        public DateTime deletedAt { get; set; }

        public Boolean estado { get; set; }

        public int lstRole { get; set; }

        public int lstView { get; set; }

        public Role roleId { get; set; }

        public View viewId { get; set; }
    }
}
