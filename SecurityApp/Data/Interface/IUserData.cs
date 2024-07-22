﻿using Entity.Dtos;
using Entity.Model.Security;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Interface
{
    public interface IUserData
    {
        Task Delete(int id);

        Task<IEnumerable<DataSelectDto>> GetAllSelect();

        Task<User> GetById(int id);

        /* INHABILITADO
         * Task<PageListDto<UserDto>> GetDataTable(QueryFilterDto filter);*/

        Task<User> Save(User entity);

        Task Update(User entity);
    }
}
