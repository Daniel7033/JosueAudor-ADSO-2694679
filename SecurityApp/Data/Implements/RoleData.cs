using Data.Interface;
using Entity.Context;
using Entity.Dtos;
using Entity.Model.Security;
using Microsoft.Extensions.Configuration;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Implements
{
    public class RoleData : IRoleData
    {
        private readonly ApplicationDbContext context;
        protected readonly IConfiguration configuration;

        public RoleData(ApplicationDbContext context, IConfiguration configuration)
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
            entity.deletedAt = DateTime.Parse(DateTime.Today.ToString());
            context.Roles.Update(entity);
            await context.SaveChangesAsync();
        }

        public async Task<IEnumerable<DataSelectDto>> GetAllSelect()
        {
            var sql = @"SELECT
                            id,
                            name,
                            description
                        FROM Role
                        WHERE deletedAt IS NULL AND estado = 1
                        ORDER BY id ASC";
            return await this.context.QueryAsync<DataSelectDto>(sql);
        }

        public async Task<Role> GetById(int id)
        {
            var sql = @"SELECT * FROM Role WHERE id = @Id ORDER BY id ASC";
            return await this.context.QueryFirstOrDefaultAsync<Role>(sql, new { Id = id });
        }

        /* INHABILITADO
         * public async Task<PageListDto<RoleDto>> GetDataTable(QueryFilterDto filter)
        {
            var pageNumber = (filter.PageNumber == 0) ? Int32.Parse(configuration["Pagination:DefaultPageNumber"]) : filter.PageNumber;
            var pageSize= (filter.PageSize == 0) ? Int32.Parse(configuration["Pagination:DefaultPageSize"]) : filter.PageSize;

            var sql = @"SELECT
                            r.id,
                            r.name AS Roles,
                            v.name AS Views
                        FROM Role AS r
                        INNER JOIN RoleView AS rv ON rv.roleId = r.id
                        INNER JOIN View AS v ON rv.viewId = v.id
                        WHERE deletedAt IS NULL AND
                        (UPPER(CONCAT(r.name, v.name)) LIKE UPPER(CONCAT('%', @filter, '%')))
                        ORDER BY '" + (filter.ColumnOrder ?? "id") +"' " + (filter.DirectionOrder ?? "asc");

            IEnumerable<RoleDto> items = await context.QueryAsync<RoleDto>(sql, new { Filter = filter.Filter });

            var pageItems = PageListDto<RoleDto>.Create(items, pageNumber, pageSize);

            return pageItems;
        }*/

        public async Task<Role> Save(Role entity)
        {
            context.Roles.Add(entity);
            await context.SaveChangesAsync();
            return entity;
        }

        public async Task Update(Role entity)
        {
            context.Entry(entity).State = Microsoft.EntityFrameworkCore.EntityState.Modified;
            await context.SaveChangesAsync();
        }

    }
}
