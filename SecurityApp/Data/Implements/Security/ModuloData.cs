using Data.Interface.Security;
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

namespace Data.Implements.Security
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
            var sql = @"SELECT * FROM Modules ORDER BY id ASC";
            return await context.QueryAsync<ModuloDto>(sql);
        }

        public async Task<IEnumerable<DataSelectDto>> GetAllSelect()
        {
            var sql = @"SELECT
                            id,
                            name AS textoMostrar
                        FROM Modules
                        WHERE estado = 1
                        ORDER BY id ASC";
            return await context.QueryAsync<DataSelectDto>(sql);
        }

        public async Task<Modulo> GetById(int id)
        {
            var sql = @"SELECT * FROM Modules WHERE id = @Id ORDER BY id ASC";
            return await context.QueryFirstOrDefaultAsync<Modulo>(sql, new { Id = id });
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
            entity.createdAt = DateTime.Parse(DateTime.Today.ToString());
            entity.estado = true;
            await context.SaveChangesAsync();
            return entity;
        }

        public async Task Update(Modulo entity)
        {
            context.Entry(entity).State = Microsoft.EntityFrameworkCore.EntityState.Modified;
            context.Entry(entity).Property(i => i.id).IsModified = false; // Ignora el Id
            entity.updatedAt = DateTime.Parse(DateTime.Today.ToString());
            await context.SaveChangesAsync();
        }

    }
}
