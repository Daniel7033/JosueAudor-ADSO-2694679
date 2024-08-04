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

        public string firstName { get; set; } = null;

        public string secondName { get; set; } = null;

        public string firstSurname { get; set; } = null;

        public string secondSurname { get; set; } = null;

        public string email { get; set; } = null;

        public string phone { get; set; } = null;

        public string gender { get; set; } = null;

        public string documentType { get; set; } = null;

        public int documentNumber { get; set; } = 0;

        public DateTime birthDate { get; set; } = default;

        public DateTime createdAt { get; set; }

        public DateTime updatedAt { get; set; }

        public DateTime deletedAt { get; set; }

        public Boolean estado { get; set; } = true;

    }
}
