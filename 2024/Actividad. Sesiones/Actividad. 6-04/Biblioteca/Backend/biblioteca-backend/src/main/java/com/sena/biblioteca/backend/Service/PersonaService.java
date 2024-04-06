package com.sena.biblioteca.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.biblioteca.backend.Entity.Persona;
import com.sena.biblioteca.backend.IRepository.IBaseRepository;
import com.sena.biblioteca.backend.IRepository.IPersonaRepository;
import com.sena.biblioteca.backend.IService.IPersonaService;

@Service 
public class PersonaService extends ABaseService<Persona> implements IPersonaService{

    @Override
	protected IBaseRepository<Persona, Long> getRepository() {
		return repository;
	}
	
	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	@Autowired
	private IPersonaRepository repository;
    
}
