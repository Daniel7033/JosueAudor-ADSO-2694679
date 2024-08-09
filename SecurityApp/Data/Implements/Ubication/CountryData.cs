using Data.Interface.Ubication;
using Entity.Context;
using Entity.Dtos;
using Entity.Dtos.Ubication;
using Entity.Model.Ubication;
using Microsoft.Extensions.Configuration;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Implements.Ubication
{
    public class CountryData : ICountryData
    {
        private readonly ApplicationDbContext context;
        protected readonly IConfiguration configuration;

        public CountryData(ApplicationDbContext context, IConfiguration configuration)
        {
            this.context = context;
            this.configuration = configuration;
        }

        public async Task Delete(int id)
        {
            var entity = await GetById(id);
            if (entity == null)
            {
                throw new Exception("DATO NO ENCONTRADO");
            }
            entity.deletedAt = DateTime.Parse(DateTime.Today.ToString());
            context.Countries.Update(entity);
            await context.SaveChangesAsync();
        }

        public async Task<IEnumerable<CountryDto>> GetAll()
        {
            var sql = @"SELECT * FROM Countries ORDER BY id ASC";
            return await context.QueryAsync<CountryDto>(sql);
        }

        public async Task<IEnumerable<DataSelectDto>> GetAllSelect()
        {
            var sql = @"SELECT 
                            id,
                            name AS TextoMostrar
                        FROM Countries
                        WHERE estado = 1
                        ORDER BY id ASC";
            return await context.QueryAsync<DataSelectDto>(sql);
        }

        public async Task<Country> GetById(int id)
        {
            var sql = @"SELECT * FROM Countries WHERE id = @Id ORDER BY id ASC";
            return await context.QueryFirstOrDefaultAsync<Country>(sql, new { Id = id });
        }

        public async Task<Country> Save(Country entity)
        {
            context.Countries.Add(entity);
            entity.createdAt = DateTime.Parse(DateTime.Today.ToString());
            entity.estado = true;
            await context.SaveChangesAsync();
            return entity;
        }

        public async Task Update(Country entity)
        {
            context.Entry(entity).State = Microsoft.EntityFrameworkCore.EntityState.Modified;
            context.Entry(entity).Property(i => i.id).IsModified = false;
            entity.updatedAt = DateTime.Parse(DateTime.Today.ToString());
            await context.SaveChangesAsync();
        }
    }
}
