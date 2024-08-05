using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entity.Model.Security
{
    public class Person
    {
        public int id { get; set; }

        public string? firstName { get; set; }

        public string? secondName { get; set; }

        public string? firstSurname { get; set; }

        public string? secondSurname { get; set; }

        public string? email { get; set; }

        public string? phone { get; set; }

        public string? gender { get; set; }

        public string? documentType { get; set; }

        public int documentNumber { get; set; } 

        public DateTime birthDate { get; set; } 

        public DateTime? createdAt { get; set; }

        public DateTime? updatedAt { get; set; }

        public DateTime? deletedAt { get; set; }

        public Boolean estado { get; set; } 

    }
}
