using Entity.Model.Security;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entity.Dtos.Security
{
    public class ViewDto
    {
        public int id { get; set; }

        public string Name { get; set; }

        public string Route { get; set; }

        public string Description { get; set; }

        public int ModuloId { get; set; }

        public Boolean Estado { get; set; }
    }
}
