package com.sena.biblioteca.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.biblioteca.backend.Entity.Autor;
import com.sena.biblioteca.backend.IRepository.IBaseRepository;
import com.sena.biblioteca.backend.IRepository.IAutorRepository;
import com.sena.biblioteca.backend.IService.IAutorService;

@Service 
public class AutorService extends ABaseService<Autor> implements IAutorService{

    @Override
	protected IBaseRepository<Autor, Long> getRepository() {
		return repository;
	}
	
	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	@Autowired
	private IAutorRepository repository;
    
}
