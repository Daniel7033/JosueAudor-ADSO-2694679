

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entity.Model.Security
{
    public class View
    {
        public int id { get; set; }

        public string name { get; set; }

        public string description { get; set; }

        public string route { get; set; }

        public int lstView { get; set; }

        public DateTime createdAt { get; set;  }

        public DateTime updatedAt { get; set; }
        
        public DateTime deletedAt { get; set; }

        public Boolean estado { get; set; }

        public Modulo moduleId { get; set; }
    }
}
