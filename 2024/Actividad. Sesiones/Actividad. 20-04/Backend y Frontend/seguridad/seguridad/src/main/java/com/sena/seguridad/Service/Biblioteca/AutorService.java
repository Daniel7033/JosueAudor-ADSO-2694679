package com.sena.seguridad.Service.Biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.seguridad.Entity.Autor;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.Biblioteca.IAutorRepository;
import com.sena.seguridad.IService.Biblioteca.IAutorService;
import com.sena.seguridad.Service.ABaseService;

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
