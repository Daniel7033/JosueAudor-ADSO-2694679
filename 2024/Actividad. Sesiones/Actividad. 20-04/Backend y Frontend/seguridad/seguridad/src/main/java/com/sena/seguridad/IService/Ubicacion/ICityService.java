package com.sena.seguridad.IService.Ubicacion;

import java.util.List;

import com.sena.seguridad.DTO.Ubicacion.ICityDto;
import com.sena.seguridad.Entity.City;
import com.sena.seguridad.IService.IBaseService;

public interface ICityService extends IBaseService<City> {
	List<ICityDto> GetListCitys();
}
