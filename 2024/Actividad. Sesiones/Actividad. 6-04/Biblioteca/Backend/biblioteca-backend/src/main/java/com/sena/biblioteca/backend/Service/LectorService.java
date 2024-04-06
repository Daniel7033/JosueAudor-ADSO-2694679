package com.sena.biblioteca.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.biblioteca.backend.Entity.Lector;
import com.sena.biblioteca.backend.IRepository.IBaseRepository;
import com.sena.biblioteca.backend.IRepository.ILectorRepository;
import com.sena.biblioteca.backend.IService.ILectorService;

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
