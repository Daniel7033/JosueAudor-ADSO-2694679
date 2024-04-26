package com.sena.seguridad.Service.Ubicacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.seguridad.Entity.Country;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.Ubicacion.ICountryRepository;
import com.sena.seguridad.IService.Ubicacion.ICountryService;
import com.sena.seguridad.Service.ABaseService;
@Service
public class CountryService extends ABaseService<Country> implements ICountryService{


	
	@Autowired
	public ICountryRepository repository;

	@Override
	protected IBaseRepository<Country, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}


	

}
