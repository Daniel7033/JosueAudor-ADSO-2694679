using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entity.Dtos.Ubication
{
    public class CountryDto
    {
        public int id { get; set; }

        public string Code { get; set; }

        public string Name { get; set; }

        public Boolean Estado { get; set; }
    }
}
