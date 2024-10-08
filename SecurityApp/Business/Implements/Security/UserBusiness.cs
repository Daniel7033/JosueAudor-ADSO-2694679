﻿using Entity.Model.Security;
using Entity.Dtos.Security;
using Entity.Dtos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Business.Interface.Security;
using Data.Interface.Security;

namespace Business.Implements.Security
{
    public class UserBusiness : IUserBusiness
    {
        private readonly IUserData data;

        public UserBusiness(IUserData data)
        {
            this.data = data;
        }

        public async Task Delete(int id)
        {
            await this.data.Delete(id);
        }

        public async Task<IEnumerable<UserDto>> GetAll()
        {
            return await this.data.GetAll();
        }

        public async Task<IEnumerable<DataSelectDto>> GetAllSelect()
        {
            return await this.data.GetAllSelect();
        }

        public async Task<UserDto> GetById(int id)
        {
            User user = await this.data.GetById(id);
            UserDto dto = new UserDto();

            dto.id = user.id;
            dto.Username = user.username;
            dto.Password = user.password;
            dto.PersonId = user.lstUser;
            dto.Estado = user.estado;

            return dto;
        }

        public async Task<User> Save(UserDto entity)
        {
            User user = new User();
            user = this.mapearDatos(user, entity);

            return await this.data.Save(user);
        }

        public async Task Update(int id, UserDto entity)
        {
            User user = await this.data.GetById(id);
            if(user == null)
            {
                throw new Exception("Dato no encontrado");
            }
            user = this.mapearDatos(user, entity);

            await this.data.Update(user);
        }

        public async Task<IEnumerable<LoginDto>> Login(string username, string password)
        {
            LoginDto login = new LoginDto();

            login.Username = username;
            login.Password = password;
            if (username != login.Username && password != login.Password)
            {
                throw new Exception("Nombre de usuario o contraseña incorrectos.");
            }

            
            return await this.data.Login(username, password);
        }

        private User mapearDatos(User user, UserDto entity)
        { 
            if (user.id == 0)
            {
                user.id = entity.id;
            }
            user.username = entity.Username;
            user.password = entity.Password;
            user.lstUser = entity.PersonId;
            user.estado = entity.Estado;

            return user;
        }
    }
}
