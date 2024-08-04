﻿

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entity.Model.Security
{
    public class View
    {
        public int id { get; set; }

        public string name { get; set; } = null;

        public string description { get; set; } = null;

        public string route { get; set; } = null;

        public int lstView { get; set; }

        public DateTime createdAt { get; set;  }

        public DateTime updatedAt { get; set; }
        
        public DateTime deletedAt { get; set; }

        public Boolean estado { get; set; } = true;

        public Modulo moduleId { get; set; }
    }
}
