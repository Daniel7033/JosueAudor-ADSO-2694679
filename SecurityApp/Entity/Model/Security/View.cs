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

        public Module moduleId { get; set; }
    }
}
