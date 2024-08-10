using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entity.Model.Ubication
{
    public class Country
    {
        public int id { get; set; }

        public string? code { get; set; }

        public string? name { get; set; }

        public DateTime createdAt { get; set; }

        public DateTime updatedAt { get; set; }

        public DateTime deletedAt { get; set; }

        public Boolean estado { get; set; }

        public ICollection<Department> Departments { get; set; }
    }
}
