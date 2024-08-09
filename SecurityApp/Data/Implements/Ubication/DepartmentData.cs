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
    public class DepartmentData : IDepartmentData
    {
        private readonly ApplicationDbContext context;
        protected readonly IConfiguration configuration;

        public DepartmentData(ApplicationDbContext context, IConfiguration configuration)
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
            context.Departments.Update(entity);
            await context.SaveChangesAsync();
        }

        public async Task<IEnumerable<DepartmentDto>> GetAll()
        {
            var sql = @"SELECT * FROM Departments ORDER BY id ASC";
            return await context.QueryAsync<DepartmentDto>(sql);
        }

        public async Task<IEnumerable<DataSelectDto>> GetAllSelect()
        {
            var sql = @"SELECT 
                            id,
                            name AS TextoMostrar
                        FROM Departments
                        WHERE estado = 1
                        ORDER BY id ASC";
            return await context.QueryAsync<DataSelectDto>(sql);
        }

        public async Task<Department> GetById(int id)
        {
            var sql = @"SELECT * FROM Departments WHERE id = @Id ORDER BY id ASC";
            return await context.QueryFirstOrDefaultAsync<Department>(sql, new { Id = id });
        }

        public async Task<Department> Save(Department entity)
        {
            context.Departments.Add(entity);
            entity.createdAt = DateTime.Parse(DateTime.Today.ToString());
            entity.estado = true;
            await context.SaveChangesAsync();
            return entity;
        }

        public async Task Update(Department entity)
        {
            context.Entry(entity).State = Microsoft.EntityFrameworkCore.EntityState.Modified;
            context.Entry(entity).Property(i => i.id).IsModified = false;
            entity.updatedAt = DateTime.Parse(DateTime.Today.ToString());
            await context.SaveChangesAsync();
        }
    }
}
