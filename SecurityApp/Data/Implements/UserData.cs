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
            var sql = @"SELECT * FROM Users ORDER BY id ASC";
            return await this.context.QueryAsync<UserDto>(sql);
        }

        public async Task<IEnumerable<DataSelectDto>> GetAllSelect()
        {
            var sql = @"SELECT
                            id,
                            CONCAT('(@', u.username, ')', ' - ',p.firstName, ' ', p.firstSurname) AS TextoMostrar
                        FROM Users AS u
                        INNER JOIN Persons AS p ON u.personId = p.id
                        WHERE estado = 1
                        ORDER BY id ASC";
            return await this.context.QueryAsync<DataSelectDto>(sql);
        }

        public async Task<User> GetById(int id)
        {
            var sql = @"SELECT * FROM Users WHERE id = @Id ORDER BY id ASC;";
            return await this.context.QueryFirstOrDefaultAsync<User>(sql, new { Id = id });
        }

        public async Task<User> Save(User entity)
        {
            context.Users.Add(entity);
            entity.createdAt = DateTime.Parse(DateTime.Today.ToString());
            entity.estado = true;
            await context.SaveChangesAsync();
            return entity;
        }

        public async Task Update(User entity)
        {
            context.Entry(entity).State = Microsoft.EntityFrameworkCore.EntityState.Modified;
            context.Entry(entity).Property(i => i.id).IsModified = false;
            entity.updatedAt = DateTime.Parse(DateTime.Today.ToString());
            await context.SaveChangesAsync();
        }
    }
}
