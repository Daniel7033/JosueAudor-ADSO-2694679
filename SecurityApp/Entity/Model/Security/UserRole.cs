﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entity.Model.Security
{
    public class UserRole
    {
        public int id { get; set; }

        public int lstUser { get; set; }

        public int lstRole { get; set; }

        public DateTime createdAt { get; set; }

        public DateTime updatedAt { get; set; }

        public DateTime deletedAt { get; set; }

        public Boolean estado { get; set; } = true;

        public User userId { get; set; }

        public Role roleId { get; set; }
    }
}
