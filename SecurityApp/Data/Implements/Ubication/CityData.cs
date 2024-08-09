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
    public class CityData : ICityData
    {
        private readonly ApplicationDbContext context;
        protected readonly IConfiguration configuration;

        public CityData(ApplicationDbContext context, IConfiguration configuration)
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
            context.Cities.Update(entity);
            await context.SaveChangesAsync();
        }

        public async Task<IEnumerable<CityDto>> GetAll()
        {
            var sql = @"SELECT * FROM Countries ORDER BY id ASC";
            return await context.QueryAsync<CityDto>(sql);
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

        public async Task<City> GetById(int id)
        {
            var sql = @"SELECT * FROM Countries WHERE id = @Id ORDER BY id ASC";
            return await context.QueryFirstOrDefaultAsync<City>(sql, new { Id = id });
        }

        public async Task<City> Save(City entity)
        {
            context.Cities.Add(entity);
            entity.createdAt = DateTime.Parse(DateTime.Today.ToString());
            entity.estado = true;
            await context.SaveChangesAsync();
            return entity;
        }

        public async Task Update(City entity)
        {
            context.Entry(entity).State = Microsoft.EntityFrameworkCore.EntityState.Modified;
            context.Entry(entity).Property(i => i.id).IsModified = false;
            entity.updatedAt = DateTime.Parse(DateTime.Today.ToString());
            await context.SaveChangesAsync();
        }
    }
}
