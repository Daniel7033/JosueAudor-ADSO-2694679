using Business.Interface.Security;
using Data.Interface;
using Entity.Dtos;
using Entity.Dtos.Security;
using Entity.Model.Security;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Business.Implements.Security
{
    public class PersonBusiness : IPersonBusiness
    {
        private readonly IPersonData data;

        public PersonBusiness(IPersonData data)
        {
            this.data = data;
        }

        public async Task Delete(int id)
        {
            await this.data.Delete(id);
        }

        public async Task<IEnumerable<PersonDto>> GetAll()
        {
            return await this.data.GetAll();
        }

        public async Task<IEnumerable<DataSelectDto>> GetAllSelect()
        {
            return await this.data.GetAllSelect();
        }

        public async Task<PersonDto> GetById(int id)
        {
            Person person = await this.data.GetById(id);
            PersonDto dto = new PersonDto();

            dto.id = person.id;
            dto.FirstName = person.firstName;
            dto.SecondName = person.secondName;
            dto.FirstSurname = person.secondSurname;
            dto.DocumentType = person.documentType;
            dto.DocumentNumber = person.documentNumber;
            dto.Email = person.email;
            dto.Telefono = person.phone;
            dto.Gender = person.gender;
            dto.BirthDate = person.birthDate;
            dto.Estado = person.estado;

            return dto;
        }

        public async Task<Person> Save(PersonDto entity)
        {
            Person person = new Person();
            person = this.mapearDatos(person, entity);

            return await this.data.Save(person);
        }

        public async Task Update(int id, PersonDto entity)
        {
            Person person = await this.data.GetById(id);
            if(person == null)
            {
                throw new Exception("Dato no encontrado");
            }
            person = this.mapearDatos(person, entity);

            await this.data.Update(person);
        }

        private Person mapearDatos(Person person, PersonDto entity)
        {
            person.id = entity.id;
            person.firstName = entity.FirstName;
            person.secondName = entity.SecondName;
            person.firstSurname = entity.FirstSurname;
            person.secondSurname = entity.SecondSurname;
            person.documentType = entity.DocumentType;
            person.documentNumber = entity.DocumentNumber;
            person.email = entity.Email;
            person.phone = entity.Telefono;
            person.gender = entity.Gender;
            person.birthDate = entity.BirthDate;
            person.estado = entity.Estado;

            return person;
        }
    }
}
