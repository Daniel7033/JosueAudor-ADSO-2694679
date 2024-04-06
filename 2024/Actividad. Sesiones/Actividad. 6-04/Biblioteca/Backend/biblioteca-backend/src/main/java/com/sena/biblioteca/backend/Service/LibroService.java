package com.sena.biblioteca.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.biblioteca.backend.Entity.Libro;
import com.sena.biblioteca.backend.IRepository.IBaseRepository;
import com.sena.biblioteca.backend.IRepository.ILibroRepository;
import com.sena.biblioteca.backend.IService.ILibroService;

@Service 
public class LibroService extends ABaseService<Libro> implements ILibroService{

    @Override
	protected IBaseRepository<Libro, Long> getRepository() {
		return repository;
	}
	
	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	@Autowired
	private ILibroRepository repository;
    
}
