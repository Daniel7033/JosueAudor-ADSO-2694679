using Business.Interface.Security;
using Data.Interface;
using Entity.Dtos;
using Entity.Dtos.Security;
using Entity.Model.Security;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Business.Implements.Security
{
    public class ViewBusiness : IViewBusiness
    {
        private readonly IViewData data;

        public ViewBusiness(IViewData data)
        {
            this.data = data;
        }

        public async Task Delete(int id)
        {
            await this.data.Delete(id);
        }

        public async Task<IEnumerable<ViewDto>> GetAll()
        {
            return await this.data.GetAll();
        }

        public async Task<IEnumerable<DataSelectDto>> GetAllSelect()
        {
            return await this.data.GetAllSelect();
        }

        public async Task<ViewDto> GetById(int id)
        {
            View view = await this.data.GetById(id);
            ViewDto dto = new ViewDto();

            dto.id = view.id;
            dto.Name = view.name;
            dto.Route = view.route;
            dto.Description = view.description;
            dto.ModuloId = view.moduleId;
            dto.Estado = view.estado;

            return dto;
        }

        public async Task<View> Save(ViewDto entity)
        {
            View view = new View();
            view = this.mapeoDatos(view, entity);

            return await this.data.Save(view);
        }

        public async Task Update(int id, ViewDto entity)
        {
            View view = await this.data.GetById(id);
            if(view == null){
                throw new Exception("Dato no encontrado");
            }
            view = this.mapeoDatos(view, entity);

            await this.data.Update(view);
        }

        private View mapeoDatos(View view, ViewDto entity)
        {
            if(view.id == 0)
            {
                view.id = entity.id;
            }
            view.route = entity.Route;
            view.name = entity.Name;
            view.description = entity.Description;
            view.moduleId.id = entity.ModuloId.id;
            view.estado = entity.Estado;

            return view;
        }
    }
}
