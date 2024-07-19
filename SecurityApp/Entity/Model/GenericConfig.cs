using Entity.Model.Security;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Entity.Model
{
    internal class GenericConfig
    {
        public void ConfiguredUser(EntityTypeBuilder<User> builder)
        {
            builder.HasIndex(i => i.username).IsUnique();
        }
        public void ConfiguredPerson(EntityTypeBuilder<Person> builder)
        {
            builder.HasIndex(i => i.documentNumber).IsUnique();
            builder.HasIndex(i => i.email).IsUnique();
            builder.HasIndex(i => i.phone).IsUnique();
        }
    }
}
