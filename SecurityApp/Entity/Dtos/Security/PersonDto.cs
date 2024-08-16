using Entity.Model.Ubication;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entity.Dtos.Security
{
    public class PersonDto
    {
        public int id { get; set; }

        //public string Nombres { get; set; }

        //public string Apellidos { get; set; }

        //public string Documentos { get; set; }

        public string FirstName { get; set; }

        public string SecondName { get; set; }

        public string FirstSurname { get; set; }

        public string SecondSurname { get; set; }

        public string Phone { get; set; }

        public string Email { get; set; }

        public string Gender { get; set; }

        public string DocumentType { get; set; }

        public int DocumentNumber { get; set; }

        public DateTime BirthDate { get; set; }

        public int City { get; set; }

        public Boolean Estado { get; set; }

    }
}
