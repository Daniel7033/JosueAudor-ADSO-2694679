package com.sena.seguridad.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.sena.seguridad.DTO.ICityDto;
import com.sena.seguridad.Entity.City;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.ICityRepository;
import com.sena.seguridad.IService.ICityService;

@Service
public class CityService extends ABaseService<City> implements ICityService{

	@Override
	protected IBaseRepository<City, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Autowired
	public ICityRepository repository;


	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	
	@Override
	public List<ICityDto> GetListCitys() {
		// TODO Auto-generated method stub
		return repository.GetListCitys();
	}


}
