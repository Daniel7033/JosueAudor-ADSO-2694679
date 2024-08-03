using Entity.Model.Security;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Extensions.Configuration;
using Microsoft.EntityFrameworkCore;
using Data.Interface;
using Entity.Dtos;
using Entity.Context;
using Entity.Dtos.Security;

namespace Data.Implements
{
    public class UserData : IUserData
    {
        private readonly ApplicationDbContext context;
        protected readonly IConfiguration configuration;

        public UserData(ApplicationDbContext context, IConfiguration configuration)
        {
            this.context = context;
            this.configuration = configuration;
        }

        public async Task Delete(int id)
        {
            var entity = await GetById(id);
            if (entity == null)
            {
                throw new Exception("Dato no encontrado");
            }
            entity.deletedAt = DateTime.Parse(DateTime.Today.ToString());
            context.Users.Update(entity);
            await context.SaveChangesAsync();
        }
        public async Task<IEnumerable<UserDto>> GetAll()
        {
            var sql = @"SELECT * FROM User ORDER BY id ASC";
            return await this.context.QueryAsync<UserDto>(sql);
        }

        public async Task<IEnumerable<DataSelectDto>> GetAllSelect()
        {
            var sql = @"SELECT
                            id,
                            CONCAT('(@', u.username, ')', ' - ',p.firstName, ' ', p.firstSurname) AS TextoMostrar
                        FROM 
                            User AS u
                        INNER JOIN Person AS p ON u.personId = p.id
                        WHERE deletedAt IS NULL AND estado = 1
                        ORDER BY id ASC;";
            return await this.context.QueryAsync<DataSelectDto>(sql);
        }

        public async Task<User> GetById(int id)
        {
            var sql = @"SELECT * FROM User WHERE id = @Id ORDER BY id ASC;";
            return await this.context.QueryFirstOrDefaultAsync<User>(sql, new { Id = id });
        }

        /* INHABILITADO
         * public async Task<PageListDto<UserDto>> GetDataTable(QueryFilterDto filter)
        {
            int pageNumber = (filter.PageNumber == 0) ? Int32.Parse(configuration["Pagination:DefaultPageNumber"]) : filter.PageNumber;
            int pageSize = (filter.PageSize = 0) ? Int32.Parse(configuration["Pagination:DefaultPageSize"]) : filter.PageSize;

            var sql = @"SELECT
                            u.id,
                            u.username,
                            CONCAT(p.firstName, ' ', p.firstSurname) AS Nombre,
                        FROM User AS u
                            INNER JOIN Person AS p ON u.personId = p.id
                            WHERE u.deletedAt IS NULL AND
                            (UPPER(CONCAT(u.username, p.firstName, p.firstSurname)) LIKE UPPER(CONCAT('%', @filter, '%')))
                            ORDER BY '" + (filter.ColumnOrder ?? "id") + "' " + (filter.DirectionOrder ?? "asc");

            IEnumerable<UserDto> items = await context.QueryAsync<UserDto>(sql, new { Filter = filter.Filter });

            var pageItems = PageListDto<UserDto>.Create(items, pageNumber, pageSize);

            return pageItems;
        }*/

        public async Task<User> Save(User entity)
        {
            context.Users.Add(entity);
            await context.SaveChangesAsync();
            return entity;
        }

        public async Task Update(User entity)
        {
            context.Entry(entity).State = Microsoft.EntityFrameworkCore.EntityState.Modified;
            await context.SaveChangesAsync();
        }


        /*partial async Task<User> GetByCode(string code)
        {
            return await this.context.Users.AsNoTracking().Where(item => item.Codigo == code).FirstOrDefaultAsync();
        }*/
    }
}
