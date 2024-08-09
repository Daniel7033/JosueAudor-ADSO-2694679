using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace Entity.Migrations
{
    /// <inheritdoc />
    public partial class cambioubicacion : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Persons_Countries_countryIdid",
                table: "Persons");

            migrationBuilder.DropIndex(
                name: "IX_Persons_countryIdid",
                table: "Persons");

            migrationBuilder.RenameColumn(
                name: "countryIdid",
                table: "Persons",
                newName: "lstCity");

            migrationBuilder.AddColumn<int>(
                name: "cityIdid",
                table: "Persons",
                type: "int",
                nullable: false,
                defaultValue: 0);

            migrationBuilder.CreateIndex(
                name: "IX_Persons_cityIdid",
                table: "Persons",
                column: "cityIdid");

            migrationBuilder.AddForeignKey(
                name: "FK_Persons_Cities_cityIdid",
                table: "Persons",
                column: "cityIdid",
                principalTable: "Cities",
                principalColumn: "id",
                onDelete: ReferentialAction.Cascade);
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Persons_Cities_cityIdid",
                table: "Persons");

            migrationBuilder.DropIndex(
                name: "IX_Persons_cityIdid",
                table: "Persons");

            migrationBuilder.DropColumn(
                name: "cityIdid",
                table: "Persons");

            migrationBuilder.RenameColumn(
                name: "lstCity",
                table: "Persons",
                newName: "countryIdid");

            migrationBuilder.CreateIndex(
                name: "IX_Persons_countryIdid",
                table: "Persons",
                column: "countryIdid");

            migrationBuilder.AddForeignKey(
                name: "FK_Persons_Countries_countryIdid",
                table: "Persons",
                column: "countryIdid",
                principalTable: "Countries",
                principalColumn: "id",
                onDelete: ReferentialAction.Cascade);
        }
    }
}
