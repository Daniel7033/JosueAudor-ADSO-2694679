using Entity.Model.Ubication;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entity.Dtos.Ubication
{
    public class DepartmentDto
    {
        public int id { get; set; }

        public string Code { get; set; }

        public string Name { get; set; }

        public int Country { get; set; } 

        public Boolean Estado { get; set; }
    }
}
