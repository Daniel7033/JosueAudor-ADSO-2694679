using Data.Interface;
using Entity.Context;
using Entity.Dtos;
using Entity.Model.Security;
using Microsoft.Extensions.Configuration;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace Data.Implements
{
    public class PersonData : IPersonData
    {
        private readonly ApplicationDbContext context;
        protected readonly IConfiguration configuration;

        public PersonData(ApplicationDbContext context, IConfiguration configuration)
        {
            this.context = context;
            this.configuration = configuration;
        }

        public async Task Delete(int id)
        {
            var entity = await GetById(id);
            if(entity == null)
            {
                throw new Exception("Dato no encontrado");
            }
        }

        public async Task<IEnumerable<DataSelectDto>> GetAllSelect()
        {
            var sql = @"SELECT
                            id,
                            CONCAT(documentType, ' ', documentNumber) AS Documento,
                            gender,
                            CONCAT(firstName, ' ', secondName) AS Nombres,
                            CONCAT(firstSurname, ' ', secondSurname) AS Apellidos,
                            email
                        FROM Person
                        WHERE deletedAt IS NULL AND Estado = 1
                        ORDER BY id ASC;";
            return await this.context.QueryAsync<DataSelectDto>(sql);
        }

        public async Task<Person> GetById(int id)
        {
            var sql = @"SELECT * FROM Person WHERE id = @Id ORDER BY id ASC;";
            return await this.context.QueryFirstOrDefaultAsync<Person>(sql, new { Id = id });
        }

        /* INHABILITADO
         * public async Task<PageListDto<PersonDto>> GetDataTable(QueryFilterDto filter)
        {
            int pageNumber = (filter.PageNumber == 0) ? Int32.Parse(configuration["Pagination:DefaultPageNumber"]) : filter.PageNumber;
            int pageSize = (filter.PageSize == 0) ? Int32.Parse(configuration["Pagination:DefaultPageSize"]) : filter.PageSize;

            var sql = @"SELECT
                            id,
                            CONCAT(documentType, ' ', documentNumber) AS Documento,
                            gender,
                            CONCAT(firstName, ' ', secondName) AS Nombres,
                            CONCAT(firstSurname, ' ', secondSurname) AS Apellidos,
                            email
                        FROM person
                        WHERE deletedAt IS NULL AND
                        (UPPER(CONCAT(documentType, documentNumber, gender, firstName, secondName, firstSurname, secondSurname, email)) LIKE UPPER(CONCAT('%', @filter, '%')))
                        ORDER BY '" + (filter.ColumnOrder ?? "id") + "' " + (filter.DirectionOrder ?? "asc");

            IEnumerable<PersonDto> items = await context.QueryAsync<PersonDto>(sql, new { Filter = filter.Filter });

            var pageItems = PageListDto<PersonDto>.Create(items, pageNumber, pageSize);

            return pageItems;
        }*/

        public async Task<Person> Save(Person entity)
        {
            context.Persons.Add(entity);
            await context.SaveChangesAsync();
            return entity;
        }

        public async Task Update(Person entity)
        {
            context.Entry(entity).State = Microsoft.EntityFrameworkCore.EntityState.Modified;
            await context.SaveChangesAsync();
        }

        //------------------------
    }
}
