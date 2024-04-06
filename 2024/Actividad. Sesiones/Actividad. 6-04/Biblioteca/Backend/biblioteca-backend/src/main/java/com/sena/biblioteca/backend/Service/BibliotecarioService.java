package com.sena.biblioteca.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.biblioteca.backend.Entity.Bibliotecario;
import com.sena.biblioteca.backend.IRepository.IBaseRepository;
import com.sena.biblioteca.backend.IRepository.IBibliotecarioRepository;
import com.sena.biblioteca.backend.IService.IBibliotecarioService;

@Service 
public class BibliotecarioService extends ABaseService<Bibliotecario> implements IBibliotecarioService{

    @Override
	protected IBaseRepository<Bibliotecario, Long> getRepository() {
		return repository;
	}
	
	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	@Autowired
	private IBibliotecarioRepository repository;
    
}
