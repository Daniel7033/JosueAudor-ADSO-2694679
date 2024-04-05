package com.sena.seguridad.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.seguridad.Entity.Employed;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.IEmployedRepository;
import com.sena.seguridad.IService.IEmployedService;

@Service
public class EmployedService extends ABaseService<Employed> implements IEmployedService{

	@Override
	protected IBaseRepository<Employed, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Autowired
	private IEmployedRepository repository;

	
	
}
