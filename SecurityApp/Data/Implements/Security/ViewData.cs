﻿using Data.Interface.Security;
using Entity.Context;
using Entity.Dtos;
using Entity.Dtos.Security;
using Entity.Model.Security;
using Microsoft.Extensions.Configuration;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Implements.Security
{
    public class ViewData : IViewData
    {
        private readonly ApplicationDbContext context;
        protected readonly IConfiguration configuration;

        public ViewData(ApplicationDbContext context, IConfiguration configuration)
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
            context.Views.Update(entity);
            await context.SaveChangesAsync();
        }

        public async Task<IEnumerable<ViewDto>> GetAll()
        {
            var sql = @"SELECT * FROM Views ORDER BY id ASC";
            return await context.QueryAsync<ViewDto>(sql);
        }

        public async Task<IEnumerable<DataSelectDto>> GetAllSelect()
        {
            var sql = @"SELECT
                            id,
                            CONCAT(name, ' (/', route, ')' AS TextoMostrar
                        FROM Views
                        WHERE estado = 1
                        ORDER BY id ASC";
            return await context.QueryAsync<DataSelectDto>(sql);
        }

        public async Task<View> GetById(int id)
        {
            var sql = @"SELECT * FROM Views WHERE id = @Id ORDER BY id ASC";
            return await context.QueryFirstOrDefaultAsync<View>(sql, new { Id = id });
        }

        /* INHABILITADO
         * public async Task<PageListDto<ViewDto>> GetDataTable(QueryFilterDto filter)
        {
            int pageNumber = (filter.PageNumber == 0) ? Int32.Parse(configuration["Pagination:DefaultPageNumber"]) : filter.PageNumber;
            int pageSize = (filter.PageSize == 0) ? Int32.Parse(configuration["Pagination:DefaultPageSize"]) : filter.PageSize;

            var sql = @"SELECT
                            v.id,
                            m.name AS Modulo,
                            CONCAT(v.name, ' Description: ', v.description) AS Vista
                        FROM View AS v
                        INNER JOIN Modulo AS m ON v.moduleId = m.id
                        WHERE v.deletedAt IS NULL AND
                        (UPPER(CONCAT(m.name, v.name)) LIKE UPPER(CONCAT('%', @filter, '%')))
                        ORDER BY '" + (filter.ColumnOrder ?? "id") + "' " + (filter.DirectionOrder ?? "asc");
            IEnumerable<ViewDto> items = await context.QueryAsync<ViewDto>(sql, new { Filter = filter.Filter });

            var pageItems = PageListDto<ViewDto>.Create(items, pageNumber, pageSize);

            return pageItems;
        }*/

        public async Task<View> Save(View entity)
        {
            context.Views.Add(entity);
            entity.createdAt = DateTime.Parse(DateTime.Today.ToString());
            entity.estado = true;
            await context.SaveChangesAsync();
            return entity;
        }

        public async Task Update(View entity)
        {
            context.Entry(entity).State = Microsoft.EntityFrameworkCore.EntityState.Modified;
            context.Entry(entity).Property(i => i.id).IsModified = false;
            entity.updatedAt = DateTime.Parse(DateTime.Today.ToString());
            await context.SaveChangesAsync();
        }
    }
}
