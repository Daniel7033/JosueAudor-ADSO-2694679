using Data.Interface;
using Entity.Context;
using Entity.Dtos;
using Entity.Dtos.Security;
using Entity.Model.Security;
using Microsoft.EntityFrameworkCore.Diagnostics;
using Microsoft.Extensions.Configuration;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Implements
{
    public class ModuloData : IModuloData
    {
        private readonly ApplicationDbContext context;
        protected readonly IConfiguration configuration;

        public ModuloData(ApplicationDbContext context, IConfiguration configuration)
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
            context.Modules.Update(entity);
            await context.SaveChangesAsync();
        }

        public async Task<IEnumerable<ModuloDto>> GetAll()
        {
            var sql = @"SELECT * FROM Modulo ORDER BY id ASC";
            return await this.context.QueryAsync<ModuloDto>(sql);
        }

        public async Task<IEnumerable<ModuloDto>> GetAllSelect()
        {
            var sql = @"SELECT
                            id,
                            name AS Nombre
                        FROM Modulo
                        WHERE deletedAt IS NULL AND estado = 1
                        ORDER BY id ASC";
            return await this.context.QueryAsync<ModuloDto>(sql);
        } 

        public async Task<Modulo> GetById(int id)
        {
            var sql = @"SELECT * FROM Modulo WHERE id = @Id ORDER BY is ASC";
            return await this.context.QueryFirstOrDefaultAsync<Modulo>(sql, new { Id = id });
        }

        /* INHABILITADO
         * public async Task<PageListDto<ModuloDto>> GetDataTable(QueryDilterDto filter)
        {
            int pageNumber = (filter.PageNumber == 0) ? Int32.Parse(configuration["Pagination:DefaultPageNumber"]) : filter.PageNumber;
            int pageSize = (filter.PageSize == 0) ? Int32.Parse(configuration["Pagination:DefaultPageSize"]) : filter.PageSize;

            var sql = @"SELECT
                            id,
                            name
                        FROM Modulo
                        WHERE deletedAt IS NULL AND
                        (UPPER(CONCAT(name)) LIKE UPPER(CONCAT('%', @filter,'%')))
                        ORDER BY '" + (filter.ColumnOrder) ?? "id" + "' " + (filter.DirectionOrder ?? "asc");

            IEnumerable<ModuloDto> items = await context.QueryAsync<ModuloDto>(sql, new { Filter = filter.Filter });

            var pageItems = PageListDto<ModuloDto>.Create(items, pageNumber, pageSize);

            return pageItems;
        }*/

        public async Task<Modulo> Save(Modulo entity)
        {
            context.Modules.Add(entity);
            await context.SaveChangesAsync();
            return entity;
        }

        public async Task Update(Modulo entity)
        {
            context.Entry(entity).State = Microsoft.EntityFrameworkCore.EntityState.Modified;
            await context.SaveChangesAsync();
        }
    }
}
