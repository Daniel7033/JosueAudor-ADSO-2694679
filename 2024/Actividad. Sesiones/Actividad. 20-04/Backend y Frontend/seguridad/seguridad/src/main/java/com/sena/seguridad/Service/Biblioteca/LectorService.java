package com.sena.seguridad.Service.Biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.seguridad.Entity.Lector;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.Biblioteca.ILectorRepository;
import com.sena.seguridad.IService.Biblioteca.ILectorService;
import com.sena.seguridad.Service.ABaseService;

@Service 
public class LectorService extends ABaseService<Lector> implements ILectorService{

    @Override
	protected IBaseRepository<Lector, Long> getRepository() {
		return repository;
	}
	
	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	@Autowired
	private ILectorRepository repository;
    
}
