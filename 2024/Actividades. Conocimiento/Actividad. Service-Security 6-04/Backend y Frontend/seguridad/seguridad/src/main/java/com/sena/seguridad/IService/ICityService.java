package com.sena.seguridad.IService;

import java.util.List;

import com.sena.seguridad.DTO.ICityDto;
import com.sena.seguridad.Entity.City;

public interface ICityService extends IBaseService<City> {
	List<ICityDto> GetListCitys();
}
